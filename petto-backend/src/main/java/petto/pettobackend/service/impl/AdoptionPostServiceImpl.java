package petto.pettobackend.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import petto.pettobackend.dto.adoptionsource.post.types.AdoptionPostDto;
import petto.pettobackend.exceptionhandling.exceptions.DocumentNotFoundException;
import petto.pettobackend.mapper.AdoptionPostMapper;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.repository.AdoptionPostRepository;
import petto.pettobackend.service.AdoptionPostService;
import petto.pettobackend.service.UserService;

@Service
public class AdoptionPostServiceImpl implements AdoptionPostService {

  private final AdoptionPostRepository adoptionPostRepository;
  private final UserService userService;

  public AdoptionPostServiceImpl(
      AdoptionPostRepository adoptionPostRepository, UserService userService) {
    this.adoptionPostRepository = adoptionPostRepository;
    this.userService = userService;
  }

  @Override
  public AdoptionPostDto save(AdoptionPostDto adoptionPostDto, String posterId) {
    if (userService.exists(posterId)) {
      adoptionPostDto.setPosterId(posterId);
      return adoptionPostDto;
    } else {
      throw new DocumentNotFoundException();
    }
  }

  @Override
  public MongoRepository getRepository() {
    return adoptionPostRepository;
  }

  @Override
  public AbstractMapper getMapper() {
    return Mappers.getMapper(AdoptionPostMapper.class);
  }
}
