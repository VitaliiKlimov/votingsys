package com.votingsys.web.user;

import com.votingsys.repository.DataJpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.votingsys.model.User;
import java.util.List;
import static com.votingsys.util.ValidationUtil.assureIdConsistent;
import static com.votingsys.util.ValidationUtil.checkNew;

public abstract class AbstractUserController {

    @Autowired
    private DataJpaUserRepository userRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public User get(int id) {
        return userRepository.get(id);
    }

    public User create(User user) {
        checkNew(user);
        return userRepository.save(user);
    }

    public void delete(int id) {
        userRepository.delete(id);
    }

    public void update(User user, int id) {
        assureIdConsistent(user, id);
        userRepository.update(user);
    }

    public User getByMail(String email) {
        return userRepository.getByEmail(email);
    }
}