package com.petto.posting.service;

import com.petto.posting.dto.post.PostDto;
import com.petto.posting.service.generics.AbstractService;

public interface PostService extends AbstractService {

  PostDto save(PostDto postDto);
}
