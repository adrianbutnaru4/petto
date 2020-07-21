package com.petto.core.service;

import com.petto.core.dto.adoptionsource.post.types.AdoptionPostDto;

public interface AdoptionPostService extends PostService {

  AdoptionPostDto saveForPoster(AdoptionPostDto adoptionPostDto, Long posterId);
}
