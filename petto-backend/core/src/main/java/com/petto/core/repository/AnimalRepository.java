package com.petto.core.repository;

import com.petto.core.model.animal.Animal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Long> {}
