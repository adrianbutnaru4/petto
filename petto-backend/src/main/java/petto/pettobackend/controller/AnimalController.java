package petto.pettobackend.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import petto.pettobackend.dto.AnimalDto;
import petto.pettobackend.service.AnimalService;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
public class AnimalController {

  private final AnimalService animalService;

  public AnimalController(AnimalService animalService) {
    this.animalService = animalService;
  }

  @PostMapping("/animals")
  public void saveAll() throws IOException {
    log.info("Saving all the animals...");
    animalService.saveAll();
  }

  @GetMapping("/animals")
  public List<AnimalDto> findAll() {
    log.info("Finding all the animals...");
    return animalService.findAll();
  }

  @DeleteMapping("/animals")
  public void deleteAll() {
    log.info("Deleting all the animals...");
    animalService.deleteAll();
  }
}
