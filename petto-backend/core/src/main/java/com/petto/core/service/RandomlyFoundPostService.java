package com.petto.core.service;

import com.petto.core.dto.adoptionsource.post.types.RandomlyFoundPostDto;

public interface RandomlyFoundPostService extends PostService {

  RandomlyFoundPostDto saveForPoster(RandomlyFoundPostDto randomlyFoundPostDto, Long posterId);
}
