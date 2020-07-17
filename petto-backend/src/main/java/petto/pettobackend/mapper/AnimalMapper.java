package petto.pettobackend.mapper;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import petto.pettobackend.dto.animal.AnimalDto;
import petto.pettobackend.dto.base.BaseDto;
import petto.pettobackend.mapper.config.AnimalMapperConfig;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.model.animal.Animal;
import petto.pettobackend.model.base.BaseDocument;

@Mapper(config = AnimalMapperConfig.class)
public abstract class AnimalMapper implements AbstractMapper {

  @InheritConfiguration(name = "mapToBaseDocument")
  @Mappings({})
  public abstract Animal mapToAnimal(AnimalDto animalDto);

  @InheritConfiguration(name = "mapToBaseDto")
  @Mappings({})
  public abstract AnimalDto mapToAnimalDto(Animal animal);

  @Override
  public BaseDocument mapToDocument(BaseDto dto) {
    return mapToAnimal((AnimalDto) dto);
  }

  @Override
  public BaseDto mapToDto(BaseDocument document) {
    return mapToAnimalDto((Animal) document);
  }
}
