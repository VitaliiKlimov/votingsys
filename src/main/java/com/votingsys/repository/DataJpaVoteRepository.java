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

    public DataJpaVoteRepository(CrudVoteRepository crudVoteRepository){
        this.crudVoteRepository = crudVoteRepository;
    }

    public List<Vote> getAll(){
        return crudVoteRepository.findAll();
    }
}
