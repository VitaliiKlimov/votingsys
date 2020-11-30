package com.votingsys.repository;

import com.votingsys.model.Vote;
import org.springframework.stereotype.Repository;

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

    public Vote get(int id){
        return crudVoteRepository.getOne(id);
    }

    public boolean delete(int id) {
        return crudVoteRepository.delete(id) != 0;
    }

    public List<Vote> getAll() {
        return crudVoteRepository.findAll();
    }
}
