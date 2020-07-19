package petto.pettobackend.service;

import petto.pettobackend.dto.adoptionsource.post.PostDto;
import petto.pettobackend.service.generics.AbstractService;

public interface PostService extends AbstractService {

  PostDto getPost(PostDto postDto, Long posterId);
}
