package com.votingsys.repository;

import com.votingsys.model.Restaurant;
import com.votingsys.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: Vitaliy Klimov
 * Date: 20.11.2020
 */
@Repository
public class DataJpaRestaurantRepository {
    private final CrudRestaurantRepository crudRestaurantRepository;

    public DataJpaRestaurantRepository(CrudRestaurantRepository crudRestaurantRepository) {
        this.crudRestaurantRepository = crudRestaurantRepository;
    }

    public Restaurant save(Restaurant restaurant) {
        return crudRestaurantRepository.save(restaurant);
    }

    public void delete(Restaurant restaurant) {
        crudRestaurantRepository.delete(restaurant);
    }

    public Restaurant get(int id) {
        return crudRestaurantRepository.findById(id).orElse(null);
    }

    public List<Restaurant> getAll() {
        return crudRestaurantRepository.findAll();
    }
}
