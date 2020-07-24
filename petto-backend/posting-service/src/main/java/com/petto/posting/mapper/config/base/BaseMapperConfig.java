package com.petto.posting.mapper.config.base;

import com.petto.posting.dto.base.BaseDto;
import com.petto.posting.model.base.BaseEntity;
import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;

@MapperConfig
public interface BaseMapperConfig {

  void mapToBaseEntity(@MappingTarget BaseEntity baseEntity, BaseDto baseDto);

  void mapToBaseDto(BaseEntity baseEntity, @MappingTarget BaseDto baseDto);
}
