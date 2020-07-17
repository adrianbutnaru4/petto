package petto.pettobackend.service;

import petto.pettobackend.dto.animal.AnimalDto;
import petto.pettobackend.service.generics.AbstractService;

public interface AnimalService extends AbstractService {

  AnimalDto save(AnimalDto animalDto, String postId);
}
