package com.petto.core.dto.adoptionsource.shelter;

import lombok.Data;
import com.petto.core.dto.adoptionsource.AdoptionSourceDto;
import com.petto.core.dto.animal.AnimalDto;

import java.util.List;

@Data
public class ShelterDto extends AdoptionSourceDto {

  private String name;

  private List<AnimalDto> animalDtos;

  private String address; // TODO: investigate appropriate map service to save shelter address
}
