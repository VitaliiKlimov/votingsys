package com.votingsys.repository;

import org.springframework.stereotype.Repository;

/**
 * User: Vitaliy Klimov
 * Date: 20.11.2020
 */
@Repository
public class DataJpaMenuRepository {
    private final CrudMenuRepository crudMenuRepository;

    public DataJpaMenuRepository(CrudMenuRepository crudMenuRepository) {
        this.crudMenuRepository = crudMenuRepository;
    }
}
