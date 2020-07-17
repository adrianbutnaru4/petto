package petto.pettobackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import petto.pettobackend.model.adoptionsource.shelter.Shelter;

@Repository
public interface ShelterRepository extends MongoRepository<Shelter, String> {}
