package com.petto.core.repository;

import com.petto.core.model.animal.Animal;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends PagingAndSortingRepository<Animal, Long> {}
