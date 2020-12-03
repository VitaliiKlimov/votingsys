package com.votingsys.repository;

import com.votingsys.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

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

    Vote getById(int id);

    @Query("SELECT v FROM Vote v WHERE v.dateTime=:dateTime AND v.user.id=:user_id AND v.restaurant.id=:rest_id")
    Vote getByDateTimeUserIdAndRestaurantId(@Param("dateTime") LocalDateTime dateTime, @Param("user_id") int user_id, @Param("rest_id") int rest_id);

}
