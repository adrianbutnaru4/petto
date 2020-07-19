package petto.pettobackend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import petto.pettobackend.model.adoptionsource.post.types.AdoptionPost;

@Repository
public interface AdoptionPostRepository extends CrudRepository<AdoptionPost, String> {}
