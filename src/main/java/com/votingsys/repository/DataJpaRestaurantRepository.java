package com.votingsys.repository;

import com.votingsys.model.Restaurant;
import com.votingsys.util.exception.NotFoundException;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

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

    public boolean delete(int id) {
        return crudRestaurantRepository.delete(id) != 0;
    }

    public Restaurant get(int id) {
        Optional<Restaurant> optionalRestaurant = crudRestaurantRepository.findById(id);
        return optionalRestaurant.orElseThrow(()->new NotFoundException("Restaurant not found"));
    }

    public List<Restaurant> getAll() {
        return crudRestaurantRepository.findAll();
    }
}
