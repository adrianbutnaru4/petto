package petto.pettobackend.service;

import petto.pettobackend.dto.adoptionsource.post.types.RandomlyFoundPostDto;

public interface RandomlyFoundPostService extends PostService {

  RandomlyFoundPostDto save(RandomlyFoundPostDto randomlyFoundPostDto, String posterId);
}
