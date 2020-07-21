package com.petto.core.repository;

import com.petto.core.model.adoptionsource.post.types.AdoptionPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptionPostRepository extends CrudRepository<AdoptionPost, Long> {}
