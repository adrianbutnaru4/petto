package petto.pettobackend.dto.adoptionsource.shelter;

import lombok.Data;
import petto.pettobackend.dto.adoptionsource.AdoptionSourceDto;
import petto.pettobackend.dto.animal.AnimalDto;

import java.util.List;

@Data
public class ShelterDto extends AdoptionSourceDto {

  private String name;

  private List<AnimalDto> animalDtos;

  private String address; // TODO: investigate appropriate map service to save shelter address
}
