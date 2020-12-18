package com.votingsys.repository;

import com.votingsys.DishTestData;
import com.votingsys.model.Dish;
import com.votingsys.util.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static com.votingsys.DishTestData.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * User: Vitaliy Klimov
 * Date: 30.11.2020
 */
@SpringJUnitConfig(locations = {"classpath:spring/spring-db.xml"})
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
@Transactional
class DataJpaDishRepositoryTest {
    @Autowired
    DataJpaDishRepository dataJpaDishRepository;

    @Test
    void save() {
        Dish newDish = DishTestData.getNew();
        Dish created = dataJpaDishRepository.save(newDish);
        DISH_MATCHER.assertMatch(newDish, created);
    }

    @Test
    void get() {
        Dish getted = dataJpaDishRepository.get(DISH3_ID);
        DISH_MATCHER.assertMatch(dish3,getted);
    }

    @Test
    void getAll() {
        List<Dish> allDishes = dataJpaDishRepository.getAll();
        DISH_MATCHER.assertMatch(allDishes, dishes);
    }

    @Test
    void delete() {
        dataJpaDishRepository.delete(DISH_ID);
        assertThrows(NotFoundException.class, () -> dataJpaDishRepository.get(DISH_ID));
    }

    @Test
    void getAllByRestaurantId() {
        List<Dish> menuRestaurant1 = dataJpaDishRepository.getAllByRestaurantId(RESTAURANT1_ID);
        DISH_MATCHER.assertMatch(menuRestaurant1, menu1);
    }

    @Test
    void getAllByRestaurantIdAndDate() {
        List<Dish> menuRestaurant2 = dataJpaDishRepository.getAllByRestaurantIdAndDate(RESTAURANT2_ID, LocalDate.of(2020, 10, 28));
        DISH_MATCHER.assertMatch(menuRestaurant2, menu2);
    }

    @Test
    void update() {
        Dish updated = DishTestData.getUpdated();
        dataJpaDishRepository.update(updated, 100006);
        DISH_MATCHER.assertMatch(updated, dataJpaDishRepository.get(100006));
    }
}