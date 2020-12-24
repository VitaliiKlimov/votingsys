package com.votingsys.web;

import com.votingsys.model.Restaurant;
import com.votingsys.repository.DataJpaRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.votingsys.util.ValidationUtil.checkNotFoundWithId;

/**
 * User: Vitaliy Klimov
 * Date: 05.12.2020
 */
@RestController
@RequestMapping(value = AdminRestaurantRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminRestaurantRestController {
    static final String REST_URL = "/rest/admin/restaurants";

    @Autowired
    private DataJpaRestaurantRepository dataJpaRestaurantRepository;

    @GetMapping("/{id}")
    public Restaurant get(@PathVariable int id) {return dataJpaRestaurantRepository.get(id);}

    @GetMapping
    public List<Restaurant> getAll() {
        return dataJpaRestaurantRepository.getAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        checkNotFoundWithId(dataJpaRestaurantRepository.delete(id), id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Restaurant create(@RequestBody Restaurant restaurant) {
        return dataJpaRestaurantRepository.save(restaurant);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody Restaurant restaurant, @PathVariable int id) {
        dataJpaRestaurantRepository.update(restaurant, id);
    }
}
