package petto.pettobackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import petto.pettobackend.model.adoptionsource.AdoptionSource;

@Repository
public interface AdoptionSourceRepository extends CrudRepository<AdoptionSource, String> {}
