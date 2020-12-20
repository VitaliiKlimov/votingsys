package com.votingsys.util;

import com.votingsys.model.Restaurant;
import com.votingsys.model.Vote;
import com.votingsys.to.RestaurantTo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: Vitaliy Klimov
 * Date: 19.12.2020
 */
public class RestaurantsUtil {

    private RestaurantsUtil() {
    }

    public static List<RestaurantTo> getTos (Collection<Restaurant> restaurants) {
        List<RestaurantTo> result = new ArrayList<>();
        restaurants.forEach(restaurant -> result.add(createTo(restaurant, getNumberOfVotes(restaurant.votes))));
        return result;
    }

    public static RestaurantTo createTo (Restaurant restaurant, int numberOfVotes) {
        return new RestaurantTo(restaurant.getId(), restaurant.getName(), numberOfVotes);
    }

    public static int getNumberOfVotes (Collection<Vote> votes) {
        return (int) votes.stream()
                .filter(vote -> vote.getDateTime().toLocalDate().equals(LocalDate.now())).count();
    }

}
