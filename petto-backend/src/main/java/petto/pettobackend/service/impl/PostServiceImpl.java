package petto.pettobackend.service.impl;

import org.springframework.stereotype.Service;
import petto.pettobackend.dto.PostDto;
import petto.pettobackend.mapper.PostMapper;
import petto.pettobackend.model.Post;
import petto.pettobackend.repository.AnimalRepository;
import petto.pettobackend.repository.PostRepository;
import petto.pettobackend.service.PostService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

  private final PostRepository postRepository;
  private final AnimalRepository animalRepository;

  public PostServiceImpl(PostRepository postRepository, AnimalRepository animalRepository) {
    this.postRepository = postRepository;
    this.animalRepository = animalRepository;
  }

  @Override
  public PostDto save() {
    Post post = new Post();
    animalRepository.findById("Caribou").ifPresent(post::setAnimal);

    return PostMapper.MAPPER.toDto(postRepository.save(post));
  }

  @Override
  public List<PostDto> findAll() {
    List<Post> posts = postRepository.findAll();
    return posts.stream().map(PostMapper.MAPPER::toDto).collect(Collectors.toList());
  }

  @Override
  public void deleteAll() {
    postRepository.deleteAll();
  }
}
