package petto.pettobackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import petto.pettobackend.dto.AnimalDto;
import petto.pettobackend.model.Animal;

@Mapper
public interface AnimalMapper {

  AnimalMapper MAPPER = Mappers.getMapper(AnimalMapper.class);

  @Mapping(source = "id", target = "id")
  Animal toModel(AnimalDto animalDto);

  @Mapping(source = "id", target = "id")
  AnimalDto toDto(Animal animal);
}
