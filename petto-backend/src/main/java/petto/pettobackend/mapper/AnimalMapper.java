package petto.pettobackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import petto.pettobackend.dto.animal.AnimalDto;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.model.animal.Animal;

@Mapper
public interface AnimalMapper extends AbstractMapper<Animal, AnimalDto> {

  AnimalMapper MAPPER = Mappers.getMapper(AnimalMapper.class);
}
