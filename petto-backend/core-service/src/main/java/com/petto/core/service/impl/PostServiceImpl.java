package com.petto.core.service.impl;

import com.petto.core.dto.base.BaseDto;
import com.petto.core.dto.post.PostDto;
import com.petto.core.mapper.PostMapper;
import com.petto.core.service.PostService;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

  private final PostMapper MAPPER = Mappers.getMapper(PostMapper.class);

  @Override
  public BaseDto getCustomPostDto(PostDto postDto) {
    return MAPPER.mapToCustomPostDto(postDto);
  }
}
