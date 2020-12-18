package com.votingsys;

import com.votingsys.model.Restaurant;

import java.util.List;

import static com.votingsys.model.AbstractBaseEntity.START_SEQ;

/**
 * User: Vitaliy Klimov
 * Date: 29.11.2020
 */
public class RestaurantTestData {
    public static final TestMatcher<Restaurant> RESTAURANT_MATCHER = TestMatcher.usingIgnoringFieldsComparator(Restaurant.class, "votes");

    public static final int RESTAURANT_ID = START_SEQ + 2;

    public static final Restaurant restaurant = new Restaurant(RESTAURANT_ID, "Перспектива");

    public static final Restaurant lesnayaZaimka = new Restaurant(RESTAURANT_ID, "Лесная заимка");

    public static final Restaurant ocean = new Restaurant(RESTAURANT_ID + 1, "Океан");

    public static final List<Restaurant> actual = List.of(lesnayaZaimka, ocean);

    public static Restaurant getNew() {
        return new Restaurant(RESTAURANT_ID, "Новый ресторан");
    }

    public static Restaurant getUpdated() {
        return new Restaurant(RESTAURANT_ID, "Обновленный ресторан");
    }
}
