package com.votingsys.repository;

import com.votingsys.model.Dish;
import com.votingsys.model.Vote;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

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

    public boolean delete(int id) {
        return crudDishRepository.delete(id) != 0;
    }

    public List<Dish> getAllByRestaurantId(int id) {return crudDishRepository.getAllByRestaurantId(id);}

    public List<Dish> getAllByRestaurantIdAndDate(int id, LocalDate date) {
        return crudDishRepository.getAllByRestaurantIdAndDate(id, date);}
}
