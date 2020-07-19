package petto.pettobackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import petto.pettobackend.model.adoptionsource.post.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, String> {}
