package petto.pettobackend.service;

import petto.pettobackend.dto.adoptionsource.post.types.LostAndFoundPostDto;

public interface LostAndFoundPostService extends PostService {

  LostAndFoundPostDto saveForPoster(LostAndFoundPostDto lostAndFoundPostDto, String posterId);
}
