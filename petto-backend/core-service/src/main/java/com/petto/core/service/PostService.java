package com.petto.core.service;

import com.petto.core.dto.base.BaseDto;
import com.petto.core.dto.post.PostDto;

public interface PostService {

  BaseDto getCustomPostDto(PostDto postDto);
}
