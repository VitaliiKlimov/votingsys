package com.votingsys.web;

import com.votingsys.model.Dish;
import com.votingsys.model.Restaurant;
import com.votingsys.model.Vote;
import com.votingsys.repository.DataJpaDishRepository;
import com.votingsys.repository.DataJpaRestaurantRepository;
import com.votingsys.repository.DataJpaVoteRepository;
import com.votingsys.to.RestaurantTo;
import com.votingsys.util.RestaurantsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

/**
 * User: Vitaliy Klimov
 * Date: 29.11.2020
 */
@RestController
@RequestMapping(value = UserRestaurantRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class UserRestaurantRestController {
    static final String REST_URL = "/rest/user/restaurants";

    @Autowired
    private DataJpaRestaurantRepository restaurantRepository;
    @Autowired
    private DataJpaDishRepository dishRepository;
    @Autowired
    private DataJpaVoteRepository voteRepository;

    @GetMapping
    public List<RestaurantTo> getAll() {
        return RestaurantsUtil.getTos(restaurantRepository.getAll());
    }

    @GetMapping("/{id}")
    public RestaurantTo get(@PathVariable int id) {
        Restaurant restaurant = restaurantRepository.get(id);
        return RestaurantsUtil.createTo(restaurant, RestaurantsUtil.getNumberOfVotes(restaurant.votes));
    }

    @GetMapping("/{id}/dishes")
    public List<Dish> getDishesByRestId(@PathVariable int id) {
        return dishRepository.getAllByRestaurantIdAndDate(id, LocalDate.now());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Vote create(@RequestBody Restaurant restaurant) {
        return voteRepository.createVoteForRestaurant(restaurant, SecurityUtil.authUserId());
    }
}
