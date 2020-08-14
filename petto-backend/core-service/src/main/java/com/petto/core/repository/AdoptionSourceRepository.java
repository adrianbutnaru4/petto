package com.petto.core.repository;

import com.petto.core.model.adoptionsource.AdoptionSource;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptionSourceRepository
    extends PagingAndSortingRepository<AdoptionSource, Long> {}
