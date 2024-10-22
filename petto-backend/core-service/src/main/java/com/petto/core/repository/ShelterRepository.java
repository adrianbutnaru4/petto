package com.petto.core.repository;

import com.petto.core.model.adoptionsource.shelter.Shelter;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelterRepository extends PagingAndSortingRepository<Shelter, Long> {}
