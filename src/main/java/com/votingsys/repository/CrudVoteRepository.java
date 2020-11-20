package com.votingsys.repository;

import com.votingsys.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: Vitaliy Klimov
 * Date: 20.11.2020
 */
@Transactional(readOnly = true)
public interface CrudVoteRepository extends JpaRepository <Vote,Integer> {
}
