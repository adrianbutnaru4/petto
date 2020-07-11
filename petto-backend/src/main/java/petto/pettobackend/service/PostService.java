package petto.pettobackend.service;

import petto.pettobackend.dto.PostDto;

import java.util.List;

public interface PostService {

  PostDto save();

  List<PostDto> findAll();

  void deleteAll();
}
