package com.votingsys.repository;

import com.votingsys.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * User: Vitaliy Klimov
 * Date: 20.11.2020
 */
@Transactional(readOnly = true)
public interface CrudVoteRepository extends JpaRepository <Vote,Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Vote v WHERE v.id=:id")
    int delete(@Param("id") int id);

    @Query("SELECT v FROM Vote v WHERE v.user.id=:id AND v.dateTime>=:dateTime")
    Vote getByUserIdAndDateTime(@Param("id") int id, @Param("dateTime") LocalDateTime dateTime);

    @Query("SELECT count(v) FROM Vote v WHERE v.restaurant.id=:rest_id AND v.dateTime>=:dateTime")
    Integer getByRestaurantIdAndDate(@Param("rest_id") int rest_id, @Param("dateTime") LocalDateTime dateTime);

}
