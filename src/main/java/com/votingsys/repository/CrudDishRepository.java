package com.votingsys.repository;

import com.votingsys.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


/**
 * User: Vitaliy Klimov
 * Date: 20.11.2020
 */
@Transactional(readOnly = true)
public interface CrudDishRepository extends JpaRepository<Dish, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Dish d WHERE d.id=:id")
    int delete(@Param("id") int id);

    @Query("SELECT d FROM Dish d WHERE d.restaurant.id=:restaurant_id")
    List<Dish> getAllByRestaurantId(@Param("restaurant_id") int restaurant_id);

    @Query("SELECT d FROM Dish d WHERE d.restaurant.id=:restaurant_id AND d.date=:date")
    List<Dish> getAllByRestaurantIdAndDate(@Param("restaurant_id") int restaurant_id, @Param("date") LocalDate date);
}
