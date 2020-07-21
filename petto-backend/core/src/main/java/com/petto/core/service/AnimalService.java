package com.petto.core.service;

import com.petto.core.dto.animal.AnimalDto;
import com.petto.core.service.generics.AbstractService;

public interface AnimalService extends AbstractService {

  AnimalDto saveForPost(AnimalDto animalDto, Long postId);
}
