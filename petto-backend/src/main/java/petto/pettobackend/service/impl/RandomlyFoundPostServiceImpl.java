package petto.pettobackend.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import petto.pettobackend.dto.adoptionsource.post.types.RandomlyFoundPostDto;
import petto.pettobackend.dto.user.UserDto;
import petto.pettobackend.exceptionhandling.exceptions.EntityNotFoundException;
import petto.pettobackend.mapper.RandomlyFoundPostMapper;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.repository.RandomlyFoundPostRepository;
import petto.pettobackend.service.RandomlyFoundPostService;
import petto.pettobackend.service.UserService;

@Service
public class RandomlyFoundPostServiceImpl implements RandomlyFoundPostService {

  private final RandomlyFoundPostRepository randomlyFoundPostRepository;
  private final UserService userService;

  public RandomlyFoundPostServiceImpl(
      RandomlyFoundPostRepository randomlyFoundPostRepository, UserService userService) {
    this.randomlyFoundPostRepository = randomlyFoundPostRepository;
    this.userService = userService;
  }

  @Override
  public RandomlyFoundPostDto saveForPoster(
      RandomlyFoundPostDto randomlyFoundPostDto, Long posterId) {
    if (userService.exists(posterId)) {
      UserDto poster = (UserDto) userService.findById(posterId);
      randomlyFoundPostDto.setPoster(poster);
      return (RandomlyFoundPostDto) save(randomlyFoundPostDto);
    } else {
      throw new EntityNotFoundException();
    }
  }

  @Override
  public CrudRepository getRepository() {
    return randomlyFoundPostRepository;
  }

  @Override
  public AbstractMapper getMapper() {
    return Mappers.getMapper(RandomlyFoundPostMapper.class);
  }
}
