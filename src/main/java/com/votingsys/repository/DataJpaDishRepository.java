package com.votingsys.repository;

import com.votingsys.model.Dish;
import com.votingsys.model.User;
import com.votingsys.model.Vote;
import com.votingsys.util.exception.NotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.votingsys.util.ValidationUtil.assureIdConsistent;

/**
 * User: Vitaliy Klimov
 * Date: 20.11.2020
 */
@Repository
public class DataJpaDishRepository {

    private final CrudDishRepository crudDishRepository;

    public DataJpaDishRepository(CrudDishRepository crudDishRepository) {
        this.crudDishRepository = crudDishRepository;
    }

    public Dish save(Dish dish) {
        return crudDishRepository.save(dish);
    }

    public Dish get(int id) {
        Optional<Dish> optionalDish = crudDishRepository.findById(id);
        return optionalDish.orElseThrow(()->new NotFoundException("Dish with id=" + id + " not found"));
    }

    public List<Dish> getAll() { return crudDishRepository.findAll();}

    public boolean delete(int id) {
        return crudDishRepository.delete(id) != 0;
    }

    public List<Dish> getAllByRestaurantId(int id) {
        return crudDishRepository.getAllByRestaurantId(id);
    }

    public List<Dish> getAllByRestaurantIdAndDate(int id, LocalDate date) {
        return crudDishRepository.getAllByRestaurantIdAndDate(id, date);
    }

    public void update(Dish dish, int id) {
        assureIdConsistent(dish, id);
        crudDishRepository.save(dish);
    }
}
