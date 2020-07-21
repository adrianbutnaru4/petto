package com.petto.core.mapper.config.base;

import com.petto.core.dto.base.BaseDto;
import com.petto.core.model.base.BaseEntity;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig
public interface BaseMapperConfig {

  void mapToBaseEntity(@MappingTarget BaseEntity baseEntity, BaseDto baseDto);

  void mapToBaseDto(BaseEntity baseEntity, @MappingTarget BaseDto baseDto);
}
