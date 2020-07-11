package petto.pettobackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import petto.pettobackend.model.Animal;

@Repository
public interface AnimalRepository extends MongoRepository<Animal, String> {}
