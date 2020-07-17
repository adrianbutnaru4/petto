package petto.pettobackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import petto.pettobackend.model.adoptionsource.post.types.RandomlyFoundPost;

@Repository
public interface RandomlyFoundPostRepository extends MongoRepository<RandomlyFoundPost, String> {}
