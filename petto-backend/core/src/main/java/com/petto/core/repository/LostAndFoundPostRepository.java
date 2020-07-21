package com.petto.core.repository;

import com.petto.core.model.adoptionsource.post.types.LostAndFoundPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LostAndFoundPostRepository extends CrudRepository<LostAndFoundPost, Long> {}
