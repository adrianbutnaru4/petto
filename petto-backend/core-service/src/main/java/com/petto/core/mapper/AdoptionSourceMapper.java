package com.petto.core.mapper;

import com.petto.core.dto.adoptionsource.AdoptionSourceDto;
import com.petto.core.dto.base.BaseDto;
import com.petto.core.mapper.config.AdoptionSourceMapperConfig;
import com.petto.core.mapper.generics.AbstractMapper;
import com.petto.core.model.adoptionsource.AdoptionSource;
import com.petto.core.model.base.BaseEntity;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

@Mapper(config = AdoptionSourceMapperConfig.class)
public abstract class AdoptionSourceMapper implements AbstractMapper {

  @InheritConfiguration(name = "mapToBaseEntity")
  @Mappings({})
  public abstract AdoptionSource mapToAdoptionSource(AdoptionSourceDto adoptionSourceDto);

  @InheritConfiguration(name = "mapToBaseDto")
  @Mappings({})
  public abstract AdoptionSourceDto mapToAdoptionSourceDto(AdoptionSource adoptionSource);

  @Override
  public AdoptionSource mapToEntity(BaseDto dto) {
    return mapToAdoptionSource((AdoptionSourceDto) dto);
  }

  @Override
  public AdoptionSourceDto mapToDto(BaseEntity entity) {
    return mapToAdoptionSourceDto((AdoptionSource) entity);
  }
}
