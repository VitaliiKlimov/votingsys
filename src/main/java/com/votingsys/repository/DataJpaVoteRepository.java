package com.votingsys.repository;

import com.votingsys.model.Restaurant;
import com.votingsys.model.Vote;
import com.votingsys.util.exception.NotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * User: Vitaliy Klimov
 * Date: 20.11.2020
 */
@Repository
public class DataJpaVoteRepository {
    private final CrudVoteRepository crudVoteRepository;
    private final CrudUserRepository crudUserRepository;

    public DataJpaVoteRepository(CrudVoteRepository crudVoteRepository, CrudUserRepository crudUserRepository) {
        this.crudVoteRepository = crudVoteRepository;
        this.crudUserRepository = crudUserRepository;
    }

    @Transactional
    public Vote save(Vote vote) {
        return crudVoteRepository.save(vote);
    }

    public Vote createVoteForRestaurant(Restaurant restaurant, int userId) {
        Vote lastVoteToday = getTodayByUserId(userId);
        if(lastVoteToday != null && lastVoteToday.getDateTime().isAfter(LocalDateTime.now().withHour(11).withMinute(0))) {
        return null;
        }
        Vote created = new Vote(LocalDateTime.now());
        if(null != lastVoteToday) created.setId(lastVoteToday.getId());
        created.setRestaurant(restaurant);
        created.setUser(crudUserRepository.getOne(userId));
        return save(created);
    }

    public Vote get(int id) {
        Optional<Vote> optionalVote = crudVoteRepository.findById(id);
        return optionalVote.orElseThrow(()->new NotFoundException("Vote with id=" + id + " not found"));
    }

    public Vote getTodayByUserId(int id) {
        return crudVoteRepository.getByUserIdAndDateTime(id, LocalDate.now().atStartOfDay());}

    public Integer getNumberVotesTodayByRestaurantId(int rest_id) {
        return crudVoteRepository.getByRestaurantIdAndDate(rest_id, LocalDate.now().atStartOfDay());}

    public boolean delete(int id) {
        return crudVoteRepository.delete(id) != 0;
    }

    public List<Vote> getAll() { return crudVoteRepository.findAll(); }
}
