package com.votingsys.repository;

import com.votingsys.model.Vote;
import com.votingsys.util.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import static com.votingsys.VoteTestData.*;
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
        Vote testVote = getNew();
        testVote.setRestaurant(ocean);
        testVote.setUser(user);
        Vote saved = dataJpaVoteRepository.save(testVote);
        VOTE_MATCHER.assertMatch(saved, testVote);
    }

    @Test
    void get() {
        Vote vote = dataJpaVoteRepository.get(VOTE1_ID);
        VOTE_MATCHER.assertMatch(vote1, vote);
    }

    @Test
    void delete() {
        dataJpaVoteRepository.delete(VOTE1_ID);
        assertThrows(NotFoundException.class, () -> dataJpaVoteRepository.get(VOTE1_ID));
    }

    @Test
    void getAll() {
        List<Vote> votes = dataJpaVoteRepository.getAll();
        VOTE_MATCHER.assertMatch(votes, List.of(vote1, vote2));
    }

    @Test
    void create() {
        Vote created = dataJpaVoteRepository.createVoteForRestaurant(ocean, USER_ID);
        VOTE_MATCHER.assertMatch(dataJpaVoteRepository.getTodayByUserId(USER_ID), created);
    }

    @Test
    void getNumberVotesTodayByRestaurantId() {
        Vote todayVote = getToday();
        todayVote.setUser(user);
        todayVote.setRestaurant(ocean);
        dataJpaVoteRepository.save(todayVote);
        assertEquals(1, dataJpaVoteRepository.getNumberVotesTodayByRestaurantId(RESTAURANT_ID));
    }

    @Test
    void getTodayByUserId() {
        Vote todayVote = getToday();
        todayVote.setUser(user);
        todayVote.setRestaurant(ocean);
        dataJpaVoteRepository.save(todayVote);
        VOTE_MATCHER.assertMatch(dataJpaVoteRepository.getTodayByUserId(USER_ID), todayVote);
    }
}