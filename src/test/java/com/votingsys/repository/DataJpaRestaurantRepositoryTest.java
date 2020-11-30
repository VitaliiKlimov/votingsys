package com.votingsys.repository;

import com.votingsys.model.Restaurant;
import com.votingsys.util.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.votingsys.repository.RestaurantTestData.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * User: Vitaliy Klimov
 * Date: 24.11.2020
 */
@SpringJUnitConfig(locations = {"classpath:spring/spring-db.xml"})
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
@Transactional
class DataJpaRestaurantRepositoryTest {

    @Autowired
    private DataJpaRestaurantRepository dataJpaRestaurantRepository;

    @Test
    void save() {
        Restaurant saved = dataJpaRestaurantRepository.save(restaurant);
        RESTAURANT_MATCHER.assertMatch(restaurant, saved);

    }

    @Test
    void delete() {
        dataJpaRestaurantRepository.delete(RESTAURANT_ID);
        assertThrows(NotFoundException.class, () -> dataJpaRestaurantRepository.get(RESTAURANT_ID));
    }

    @Test
    void get() {
        Restaurant restaurant = dataJpaRestaurantRepository.get(RESTAURANT_ID + 1);
        RESTAURANT_MATCHER.assertMatch(ocean, restaurant);
    }

    @Test
    void getAll() {
        List<Restaurant> restaurants = dataJpaRestaurantRepository.getAll();
        RESTAURANT_MATCHER.assertMatch(actual, restaurants);
    }
}