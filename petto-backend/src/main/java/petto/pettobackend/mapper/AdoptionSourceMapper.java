package petto.pettobackend.mapper;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import petto.pettobackend.dto.adoptionsource.AdoptionSourceDto;
import petto.pettobackend.dto.base.BaseDto;
import petto.pettobackend.mapper.config.AdoptionSourceMapperConfig;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.model.adoptionsource.AdoptionSource;
import petto.pettobackend.model.base.BaseDocument;

@Mapper(config = AdoptionSourceMapperConfig.class)
public abstract class AdoptionSourceMapper implements AbstractMapper {

  @InheritConfiguration(name = "mapToBaseDocument")
  @Mappings({})
  public abstract AdoptionSource mapToAdoptionSource(AdoptionSourceDto adoptionSourceDto);

  @InheritConfiguration(name = "mapToBaseDto")
  @Mappings({})
  public abstract AdoptionSourceDto mapToAdoptionSourceDto(AdoptionSource adoptionSource);

  @Override
  public BaseDocument mapToDocument(BaseDto dto) {
    return mapToAdoptionSource((AdoptionSourceDto) dto);
  }

  @Override
  public BaseDto mapToDto(BaseDocument document) {
    return mapToAdoptionSourceDto((AdoptionSource) document);
  }
}
