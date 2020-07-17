package petto.pettobackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import petto.pettobackend.model.adoptionsource.post.types.LostAndFoundPost;

@Repository
public interface LostAndFoundPostRepository extends MongoRepository<LostAndFoundPost, String> {}
