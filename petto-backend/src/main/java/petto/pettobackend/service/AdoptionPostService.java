package petto.pettobackend.service;

import petto.pettobackend.dto.adoptionsource.post.types.AdoptionPostDto;

public interface AdoptionPostService extends PostService {

  AdoptionPostDto save(AdoptionPostDto adoptionPostDto, String posterId);
}
