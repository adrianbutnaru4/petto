package petto.pettobackend.service;

import petto.pettobackend.dto.animal.AnimalDto;
import petto.pettobackend.service.generics.AbstractService;

public interface AnimalService extends AbstractService {

  AnimalDto saveForPost(AnimalDto animalDto, String postId);
}
