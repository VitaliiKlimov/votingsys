package com.votingsys.web.json;

import com.votingsys.model.Restaurant;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.votingsys.RestaurantTestData.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * User: Vitaliy Klimov
 * Date: 07.12.2020
 */
class JsonUtilTest {
    @Test
    void readWriteValue() throws Exception {
        String json = JsonUtil.writeValue(ocean);
        System.out.println(json);
        Restaurant restaurant = JsonUtil.readValue(json, Restaurant.class);
        RESTAURANT_MATCHER.assertMatch(restaurant, ocean);
    }

    @Test
    void readWriteValues() throws Exception {
        String json = JsonUtil.writeValue(actual);
        System.out.println(json);
        List<Restaurant> restaurants = JsonUtil.readValues(json, Restaurant.class);
        RESTAURANT_MATCHER.assertMatch(restaurants, actual);
    }
}