package com.petto.core.service;

import com.petto.core.dto.adoptionsource.post.BasePostDto;
import com.petto.core.dto.post.PostDto;

public interface PostService {

  BasePostDto getCustomPostDto(PostDto postDto);
}
