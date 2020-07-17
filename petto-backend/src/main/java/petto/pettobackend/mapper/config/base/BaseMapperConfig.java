package petto.pettobackend.mapper.config.base;

import org.mapstruct.MapperConfig;
import org.mapstruct.MappingTarget;
import petto.pettobackend.dto.base.BaseDto;
import petto.pettobackend.model.base.BaseDocument;

@MapperConfig
public interface BaseMapperConfig {

  void mapToBaseDocument(@MappingTarget BaseDocument baseDocument, BaseDto baseDto);

  void mapToBaseDto(BaseDocument baseDocument, @MappingTarget BaseDto baseDto);
}
