package petto.pettobackend.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import petto.pettobackend.dto.adoptionsource.post.types.LostAndFoundPostDto;
import petto.pettobackend.exceptionhandling.exceptions.DocumentNotFoundException;
import petto.pettobackend.mapper.LostAndFoundPostMapper;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.repository.LostAndFoundPostRepository;
import petto.pettobackend.service.LostAndFoundPostService;
import petto.pettobackend.service.UserService;

@Service
public class LostAndFoundPostServiceImpl implements LostAndFoundPostService {

  private final LostAndFoundPostRepository lostAndFoundPostRepository;
  private final UserService userService;

  public LostAndFoundPostServiceImpl(
      LostAndFoundPostRepository lostAndFoundPostRepository, UserService userService) {
    this.lostAndFoundPostRepository = lostAndFoundPostRepository;
    this.userService = userService;
  }

  @Override
  public LostAndFoundPostDto save(LostAndFoundPostDto lostAndFoundPostDto, String posterId) {
    if (userService.exists(posterId)) {
      lostAndFoundPostDto.setPosterId(posterId);
      return (LostAndFoundPostDto) save(lostAndFoundPostDto);
    } else {
      throw new DocumentNotFoundException();
    }
  }

  @Override
  public MongoRepository getRepository() {
    return lostAndFoundPostRepository;
  }

  @Override
  public AbstractMapper getMapper() {
    return Mappers.getMapper(LostAndFoundPostMapper.class);
  }
}
