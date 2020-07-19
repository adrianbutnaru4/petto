package petto.pettobackend.service;

import petto.pettobackend.dto.adoptionsource.post.types.LostAndFoundPostDto;

public interface LostAndFoundPostService extends PostService {

  LostAndFoundPostDto saveForPoster(LostAndFoundPostDto lostAndFoundPostDto, Long posterId);
}
