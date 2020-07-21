package com.petto.core.service;

import com.petto.core.dto.adoptionsource.post.PostDto;
import com.petto.core.service.generics.AbstractService;

public interface PostService extends AbstractService {

  PostDto getPost(PostDto postDto, Long posterId);
}
