package com.votingsys.util;

import com.votingsys.model.Dish;
import com.votingsys.model.Restaurant;
import com.votingsys.to.DishTo;

/**
 * User: Vitaliy Klimov
 * Date: 21.12.2020
 */
public class DishUtil {

    private DishUtil () {

    }

    public static Dish getFromTo(DishTo dishTo) {
        Dish created = new Dish(dishTo.getId(), dishTo.getDescription(), dishTo.getDate(), dishTo.getPrice());
        Restaurant restaurant = new Restaurant();
        restaurant.setId(dishTo.getRestaurantId());
        created.setRestaurant(restaurant);
        return created;
    }
}
