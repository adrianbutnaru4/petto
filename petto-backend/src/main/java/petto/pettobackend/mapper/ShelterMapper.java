package petto.pettobackend.mapper;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import petto.pettobackend.dto.adoptionsource.shelter.ShelterDto;
import petto.pettobackend.dto.base.BaseDto;
import petto.pettobackend.mapper.config.AdoptionSourceMapperConfig;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.model.adoptionsource.shelter.Shelter;
import petto.pettobackend.model.base.BaseDocument;

@Mapper(config = AdoptionSourceMapperConfig.class)
public abstract class ShelterMapper implements AbstractMapper {

  @InheritConfiguration(name = "mapToBaseDocument")
  @Mappings({})
  public abstract Shelter mapToShelter(ShelterDto shelterDto);

  @InheritConfiguration(name = "mapToBaseDto")
  @Mappings({})
  public abstract ShelterDto mapToShelterDto(Shelter shelter);

  @Override
  public BaseDocument mapToDocument(BaseDto dto) {
    return mapToShelter((ShelterDto) dto);
  }

  @Override
  public BaseDto mapToDto(BaseDocument document) {
    return mapToShelterDto((Shelter) document);
  }
}
