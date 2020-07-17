package petto.pettobackend.service;

import petto.pettobackend.dto.adoptionsource.post.types.LostAndFoundPostDto;

public interface LostAndFoundPostService extends PostService {

  LostAndFoundPostDto save(LostAndFoundPostDto lostAndFoundPostDto, String posterId);
}
