package com.petto.posting.repository;

import com.petto.posting.model.Post;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends PagingAndSortingRepository<Post, Long> {
  List<Post> findAllByPosterId(Long posterId);

  List<Post> findAllByType(String type);
}
