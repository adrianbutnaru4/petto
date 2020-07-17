package petto.pettobackend.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import petto.pettobackend.dto.animal.AnimalDto;
import petto.pettobackend.exceptionhandling.exceptions.DocumentNotFoundException;
import petto.pettobackend.mapper.AnimalMapper;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.repository.AnimalRepository;
import petto.pettobackend.service.AnimalService;
import petto.pettobackend.service.PostService;

@Service
public class AnimalServiceImpl implements AnimalService {

  private final AnimalRepository animalRepository;
  private final PostService postService;

  public AnimalServiceImpl(
      AnimalRepository animalRepository, @Qualifier("postServiceImpl") PostService postService) {
    this.animalRepository = animalRepository;
    this.postService = postService;
  }

  @Override
  public AnimalDto save(AnimalDto animalDto, String postId) {
    if (postService.exists(postId)) {
      animalDto.setPostId(postId);
      return (AnimalDto) save(animalDto);
    } else {
      throw new DocumentNotFoundException();
    }
  }

  @Override
  public MongoRepository getRepository() {
    return animalRepository;
  }

  @Override
  public AbstractMapper getMapper() {
    return Mappers.getMapper(AnimalMapper.class);
  }
}
