package com.votingsys.repository;

import com.votingsys.model.User;
import com.votingsys.util.exception.NotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    public boolean delete(int id) {
        return crudRepository.delete(id) != 0;
    }

    public User get(int id) {
        Optional<User> optionalUser = crudRepository.findById(id);//.orElseThrow(()->new NotFoundException("user not found"));
        return optionalUser.orElseThrow(()->new NotFoundException("user not found")); /*.orElse(null)*/
    }

    public User getByEmail(String email) {
        return crudRepository.getByEmail(email);
    }

    public List<User> getAll() {
        return crudRepository.findAll(SORT_NAME_EMAIL);
    }

}
