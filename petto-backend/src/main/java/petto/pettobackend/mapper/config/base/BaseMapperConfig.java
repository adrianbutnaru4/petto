package petto.pettobackend.mapper.config.base;

import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;
import petto.pettobackend.dto.base.BaseDto;
import petto.pettobackend.model.base.BaseEntity;

@MapperConfig
public interface BaseMapperConfig {

  void mapToBaseEntity(@MappingTarget BaseEntity baseEntity, BaseDto baseDto);

  void mapToBaseDto(BaseEntity baseEntity, @MappingTarget BaseDto baseDto);
}
