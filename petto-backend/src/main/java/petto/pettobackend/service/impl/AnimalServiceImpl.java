package petto.pettobackend.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import petto.pettobackend.dto.adoptionsource.AdoptionSourceDto;
import petto.pettobackend.dto.adoptionsource.post.PostDto;
import petto.pettobackend.dto.animal.AnimalDto;
import petto.pettobackend.exceptionhandling.exceptions.EntityNotFoundException;
import petto.pettobackend.mapper.AnimalMapper;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.repository.AnimalRepository;
import petto.pettobackend.service.AdoptionSourceService;
import petto.pettobackend.service.AnimalService;

@Service
public class AnimalServiceImpl implements AnimalService {

  private final AnimalRepository animalRepository;
  private final AdoptionSourceService adoptionSourceService;

  public AnimalServiceImpl(
      AnimalRepository animalRepository, AdoptionSourceService adoptionSourceService) {
    this.animalRepository = animalRepository;
    this.adoptionSourceService = adoptionSourceService;
  }

  @Override
  public AnimalDto saveForPost(AnimalDto animalDto, String postId) {
    if (adoptionSourceService.exists(postId)) {
      AdoptionSourceDto post = (AdoptionSourceDto) adoptionSourceService.findById(postId);
      animalDto.setPost((PostDto) post);
      return (AnimalDto) save(animalDto);
    } else {
      throw new EntityNotFoundException();
    }
  }

  @Override
  public CrudRepository getRepository() {
    return animalRepository;
  }

  @Override
  public AbstractMapper getMapper() {
    return Mappers.getMapper(AnimalMapper.class);
  }
}
