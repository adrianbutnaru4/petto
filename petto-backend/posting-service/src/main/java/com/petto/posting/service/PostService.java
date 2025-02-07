package com.petto.posting.service;

import com.petto.posting.dto.post.PostDto;
import com.petto.posting.service.generics.AbstractService;

import java.util.List;

public interface PostService extends AbstractService {

  PostDto save(PostDto postDto);

  List<PostDto> findAllByPosterId(Long posterId);

  List<PostDto> findAllByType(String type);
}
