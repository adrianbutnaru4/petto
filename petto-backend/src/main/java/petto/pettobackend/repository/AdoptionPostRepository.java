package petto.pettobackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import petto.pettobackend.model.adoptionsource.post.types.AdoptionPost;

@Repository
public interface AdoptionPostRepository extends MongoRepository<AdoptionPost, String> {}
