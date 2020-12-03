package com.votingsys.repository;

import com.votingsys.model.Vote;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.votingsys.repository.VoteTestData.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * User: Vitaliy Klimov
 * Date: 30.11.2020
 */
@SpringJUnitConfig(locations = {"classpath:spring/spring-db.xml"})
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
@Transactional
class DataJpaVoteRepositoryTest {

    @Autowired
    DataJpaVoteRepository dataJpaVoteRepository;

    @Test
    void save() {
    }

    @Test
    void get() {
        Vote vote = dataJpaVoteRepository.get(VOTE1_ID);
        VOTE_MATCHER.assertMatch(vote1,vote);
    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {
        List<Vote> votes = dataJpaVoteRepository.getAll();
        VOTE_MATCHER.assertMatch(votes, List.of(vote1,vote2));
    }

    @Test
    void testSave() {
    }

    @Test
    void getByDateTimeUserIdAndRestaurantId() {
    }
}