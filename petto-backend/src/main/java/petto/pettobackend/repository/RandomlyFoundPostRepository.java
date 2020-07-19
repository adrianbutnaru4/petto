package petto.pettobackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import petto.pettobackend.model.adoptionsource.post.types.RandomlyFoundPost;

@Repository
public interface RandomlyFoundPostRepository extends CrudRepository<RandomlyFoundPost, String> {}
