package com.petto.core.repository;

import com.petto.core.model.adoptionsource.post.types.RandomlyFoundPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RandomlyFoundPostRepository extends CrudRepository<RandomlyFoundPost, Long> {}
