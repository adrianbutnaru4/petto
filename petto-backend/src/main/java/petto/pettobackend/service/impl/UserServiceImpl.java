package petto.pettobackend.service.impl;

import org.springframework.stereotype.Service;
import petto.pettobackend.dto.UserDto;
import petto.pettobackend.mapper.UserMapper;
import petto.pettobackend.model.User;
import petto.pettobackend.repository.PostRepository;
import petto.pettobackend.repository.UserRepository;
import petto.pettobackend.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final PostRepository postRepository;

  public UserServiceImpl(UserRepository userRepository, PostRepository postRepository) {
    this.userRepository = userRepository;
    this.postRepository = postRepository;
  }

  @Override
  public UserDto save() {
    User user = new User();
    user.setFirstName("Adrian");
    user.setLastName("Butnaru");
    user.setPosts(postRepository.findAll());

    return UserMapper.MAPPER.toDto(userRepository.save(user));
  }

  @Override
  public List<UserDto> findAll() {
    List<User> users = userRepository.findAll();
    return users.stream().map(UserMapper.MAPPER::toDto).collect(Collectors.toList());
  }

  @Override
  public void deleteAll() {
    userRepository.deleteAll();
  }
}
