package com.petto.core.service;

import com.petto.core.dto.adoptionsource.post.types.LostAndFoundPostDto;

public interface LostAndFoundPostService extends PostService {

  LostAndFoundPostDto saveForPoster(LostAndFoundPostDto lostAndFoundPostDto, Long posterId);
}
