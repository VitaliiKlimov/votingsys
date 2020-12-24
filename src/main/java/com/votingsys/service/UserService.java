package com.votingsys.service;

import com.votingsys.AuthorizedUser;
import com.votingsys.model.User;
import com.votingsys.repository.DataJpaUserRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.List;
import static com.votingsys.util.UserUtil.prepareToSave;
import static com.votingsys.util.ValidationUtil.checkNotFound;
import static com.votingsys.util.ValidationUtil.checkNotFoundWithId;

@Service("userService")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserService implements UserDetailsService {

    private final DataJpaUserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserService(DataJpaUserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAll() {
        return repository.getAll();
    }

    public User get(int id) { return repository.get(id);}

    public User save(User user) {
        return prepareAndSave(user);
    }

    public void delete(int id) {checkNotFoundWithId(repository.delete(id), id);}

    public User getByEmail(String email) {
        return checkNotFound(repository.getByEmail(email), "email=" + email);}

    public void update(User user) {
        Assert.notNull(user, "user must not be null");
        checkNotFoundWithId(prepareAndSave(user), user.id());
    }

    @Override
    public AuthorizedUser loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.getByEmail(email.toLowerCase());
        if (user == null) {
            throw new UsernameNotFoundException("User " + email + " is not found");
        }
        return new AuthorizedUser(user);
    }

    private User prepareAndSave(User user) {
        return repository.save(prepareToSave(user, passwordEncoder));
    }

}