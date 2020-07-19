package petto.pettobackend.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import petto.pettobackend.dto.adoptionsource.post.types.AdoptionPostDto;
import petto.pettobackend.dto.user.UserDto;
import petto.pettobackend.exceptionhandling.exceptions.EntityNotFoundException;
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
  public AdoptionPostDto saveForPoster(AdoptionPostDto adoptionPostDto, Long posterId) {
    if (userService.exists(posterId)) {
      UserDto poster = (UserDto) userService.findById(posterId);
      adoptionPostDto.setPoster(poster);
      return (AdoptionPostDto) save(adoptionPostDto);
    } else {
      throw new EntityNotFoundException();
    }
  }

  @Override
  public CrudRepository getRepository() {
    return adoptionPostRepository;
  }

  @Override
  public AbstractMapper getMapper() {
    return Mappers.getMapper(AdoptionPostMapper.class);
  }
}
