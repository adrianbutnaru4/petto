package petto.pettobackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import petto.pettobackend.model.adoptionsource.shelter.Shelter;

@Repository
public interface ShelterRepository extends CrudRepository<Shelter, String> {}
