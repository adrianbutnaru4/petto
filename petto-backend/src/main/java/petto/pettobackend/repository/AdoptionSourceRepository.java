package petto.pettobackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import petto.pettobackend.model.adoptionsource.AdoptionSource;

@Repository
public interface AdoptionSourceRepository extends MongoRepository<AdoptionSource, String> {}
