package com.petto.core.service.impl;

import com.petto.core.dto.adoptionsource.AdoptionSourceDto;
import com.petto.core.dto.adoptionsource.post.PostDto;
import com.petto.core.dto.animal.AnimalDto;
import com.petto.core.exceptionhandling.exceptions.EntityNotFoundException;
import com.petto.core.mapper.AnimalMapper;
import com.petto.core.repository.AnimalRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.petto.core.mapper.generics.AbstractMapper;
import com.petto.core.service.AdoptionSourceService;
import com.petto.core.service.AnimalService;

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
  public AnimalDto saveForPost(AnimalDto animalDto, Long postId) {
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
