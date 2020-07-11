package petto.pettobackend.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import petto.pettobackend.dto.AnimalDto;
import petto.pettobackend.mapper.AnimalMapper;
import petto.pettobackend.model.Animal;
import petto.pettobackend.repository.AnimalRepository;
import petto.pettobackend.service.AnimalService;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalServiceImpl implements AnimalService {

  private final AnimalRepository animalRepository;

  public AnimalServiceImpl(AnimalRepository animalRepository) {
    this.animalRepository = animalRepository;
  }

  @Override
  public void saveAll() throws IOException {
    ObjectMapper mapper = new ObjectMapper();

    InputStream fileInputStream = new ClassPathResource("data/animals.json").getInputStream();
    List<AnimalDto> animalDtos = mapper.readValue(fileInputStream, new TypeReference<>() {});
    fileInputStream.close();

    animalDtos.stream().map(AnimalMapper.MAPPER::toModel).forEach(animalRepository::save);
  }

  @Override
  public List<AnimalDto> findAll() {
    List<Animal> animals = animalRepository.findAll();
    return animals.stream().map(AnimalMapper.MAPPER::toDto).collect(Collectors.toList());
  }

  @Override
  public void deleteAll() {
    animalRepository.deleteAll();
  }
}
