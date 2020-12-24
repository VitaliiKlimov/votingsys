package com.votingsys.web;

import com.votingsys.model.Dish;
import com.votingsys.model.Restaurant;
import com.votingsys.repository.DataJpaDishRepository;
import com.votingsys.to.DishTo;
import com.votingsys.util.DishUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * User: Vitaliy Klimov
 * Date: 29.11.2020
 */
@RestController
@RequestMapping(value = AdminDishRestController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminDishRestController {
    static final String REST_URL = "/rest/admin/dishes";

    @Autowired
    private DataJpaDishRepository dishRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Dish create(@RequestBody DishTo dishTo) {
        return dishRepository.save(DishUtil.getFromTo(dishTo));
    }

    @GetMapping
    public List<Dish> getAll() {
        return dishRepository.getAll();
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody Dish dish, @PathVariable int id) {
        dishRepository.update(dish, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        dishRepository.delete(id);
    }
}
