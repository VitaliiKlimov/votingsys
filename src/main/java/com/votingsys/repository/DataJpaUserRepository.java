package com.votingsys.repository;

import com.votingsys.model.User;
import com.votingsys.util.exception.NotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import java.util.List;
import java.util.Optional;
import static com.votingsys.util.ValidationUtil.checkNotFound;
import static com.votingsys.util.ValidationUtil.checkNotFoundWithId;

/**
 * User: Vitaliy Klimov
 * Date: 19.11.2020
 */
@Repository
public class DataJpaUserRepository {
    private static final Sort SORT_NAME_EMAIL = Sort.by(Sort.Direction.ASC, "name", "email");

    private final CrudUserRepository crudRepository;

    public DataJpaUserRepository(CrudUserRepository crudRepository) {

        this.crudRepository = crudRepository;
    }

    public User save(User user) {
        return crudRepository.save(user);
    }

    public void delete(int id) {
        checkNotFoundWithId(crudRepository.delete(id) !=0, id);
    }

    public User get(int id) {
        Optional<User> optionalUser = crudRepository.findById(id);
        return optionalUser.orElseThrow(() -> new NotFoundException("user with id=" + id + " not found"));
    }

    public User getByEmail(String email) {
        Assert.notNull(email, "email must not be null");
        return checkNotFound(crudRepository.getByEmail(email), "email=" + email);
    }

    public List<User> getAll() {
        return crudRepository.findAll(SORT_NAME_EMAIL);
    }

    public void update(User user) {
        Assert.notNull(user, "user must not be null");
        checkNotFoundWithId(crudRepository.save(user), user.id());
    }

    public User create(User user) {
        Assert.notNull(user, "user must not be null");
        return crudRepository.save(user);
    }

}
