package petto.pettobackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import petto.pettobackend.model.adoptionsource.post.types.LostAndFoundPost;

@Repository
public interface LostAndFoundPostRepository extends CrudRepository<LostAndFoundPost, String> {}
