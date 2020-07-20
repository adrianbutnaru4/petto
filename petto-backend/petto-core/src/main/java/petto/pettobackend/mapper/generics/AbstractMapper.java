package petto.pettobackend.mapper.generics;

import petto.pettobackend.dto.base.BaseDto;
import petto.pettobackend.model.base.BaseEntity;

public interface AbstractMapper<E extends BaseEntity, DTO extends BaseDto> {

  E mapToEntity(DTO dto);

  DTO mapToDto(E entity);
}
