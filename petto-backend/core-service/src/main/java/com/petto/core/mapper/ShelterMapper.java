package com.petto.core.mapper;

import com.petto.core.dto.adoptionsource.shelter.ShelterDto;
import com.petto.core.dto.base.BaseDto;
import com.petto.core.mapper.config.ShelterMapperConfig;
import com.petto.core.mapper.generics.AbstractMapper;
import com.petto.core.model.adoptionsource.shelter.Shelter;
import com.petto.core.model.base.BaseEntity;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

@Mapper(config = ShelterMapperConfig.class)
public abstract class ShelterMapper implements AbstractMapper {

  @InheritConfiguration(name = "mapToBaseEntity")
  @Mappings({})
  public abstract Shelter mapToShelter(ShelterDto shelterDto);

  @InheritConfiguration(name = "mapToBaseDto")
  @Mappings({})
  public abstract ShelterDto mapToShelterDto(Shelter shelter);

  @Override
  public Shelter mapToEntity(BaseDto dto) {
    return mapToShelter((ShelterDto) dto);
  }

  @Override
  public ShelterDto mapToDto(BaseEntity entity) {
    return mapToShelterDto((Shelter) entity);
  }
}
