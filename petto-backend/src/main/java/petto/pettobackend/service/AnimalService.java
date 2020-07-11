package petto.pettobackend.service;

import petto.pettobackend.dto.AnimalDto;

import java.io.IOException;
import java.util.List;

public interface AnimalService {

  void saveAll() throws IOException;

  List<AnimalDto> findAll();

  void deleteAll();
}
