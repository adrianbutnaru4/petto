package com.petto.core.mapper;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import com.petto.core.dto.animal.AnimalDto;
import com.petto.core.dto.base.BaseDto;
import com.petto.core.mapper.config.AnimalMapperConfig;
import com.petto.core.mapper.generics.AbstractMapper;
import com.petto.core.model.animal.Animal;
import com.petto.core.model.base.BaseEntity;

@Mapper(config = AnimalMapperConfig.class)
public abstract class AnimalMapper implements AbstractMapper {

  @InheritConfiguration(name = "mapToBaseEntity")
  @Mappings({})
  public abstract Animal mapToAnimal(AnimalDto animalDto);

  @InheritConfiguration(name = "mapToBaseDto")
  @Mappings({})
  public abstract AnimalDto mapToAnimalDto(Animal animal);

  @Override
  public BaseEntity mapToEntity(BaseDto dto) {
    return mapToAnimal((AnimalDto) dto);
  }

  @Override
  public BaseDto mapToDto(BaseEntity entity) {
    return mapToAnimalDto((Animal) entity);
  }
}
