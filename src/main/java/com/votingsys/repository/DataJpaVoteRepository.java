package com.votingsys.repository;

import com.votingsys.model.Vote;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * User: Vitaliy Klimov
 * Date: 20.11.2020
 */
@Repository
public class DataJpaVoteRepository {
    private final CrudVoteRepository crudVoteRepository;

    public DataJpaVoteRepository(CrudVoteRepository crudVoteRepository) {
        this.crudVoteRepository = crudVoteRepository;
    }

    public Vote save(Vote vote) {
        return crudVoteRepository.save(vote);
    }

    public Vote get(int id) { return crudVoteRepository.getById(id); }

    public Vote getByDateTimeUserIdAndRestaurantId(LocalDateTime dateTime, int user_id, int rest_id) {
        return crudVoteRepository.getByDateTimeUserIdAndRestaurantId(dateTime,user_id, rest_id);}

    public boolean delete(int id) {
        return crudVoteRepository.delete(id) != 0;
    }

    public List<Vote> getAll() { return crudVoteRepository.findAll(); }
}
