package petto.pettobackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import petto.pettobackend.model.animal.Animal;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, String> {}
