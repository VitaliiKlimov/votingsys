package com.votingsys.repository;

import com.votingsys.UserTestData;
import com.votingsys.model.User;
import com.votingsys.util.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.votingsys.UserTestData.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * User: Vitaliy Klimov
 * Date: 23.11.2020
 */

@SpringJUnitConfig(locations = {"classpath:spring/spring-db.xml"})
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
@Transactional
class DataJpaUserRepositoryTest {
    @Autowired
    DataJpaUserRepository dataJpaUserRepository;

    @Test
    void delete() {
        dataJpaUserRepository.delete(USER_ID);
        assertThrows(NotFoundException.class, () -> dataJpaUserRepository.get(USER_ID));
    }

    @Test
    void get() {
        User user = dataJpaUserRepository.get(ADMIN_ID);
        USER_MATCHER.assertMatch(user, admin);
    }

    @Test
    void getByEmail() {
        User user = dataJpaUserRepository.getByEmail(admin.getEmail());
        USER_MATCHER.assertMatch(user, admin);
    }

    @Test
    void getAll() {
        List<User> userList = dataJpaUserRepository.getAll();
        USER_MATCHER.assertMatch(userList, admin, user);
    }

    @Test
    void save() {
        User created = dataJpaUserRepository.save(user);
        USER_MATCHER.assertMatch(created, UserTestData.user);
    }

    @Test
    void create() {
        User created = dataJpaUserRepository.create(user);
        USER_MATCHER.assertMatch(created, UserTestData.user);
    }
}