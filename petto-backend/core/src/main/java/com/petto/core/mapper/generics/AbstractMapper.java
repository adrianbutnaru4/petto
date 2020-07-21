package com.petto.core.mapper.generics;

import com.petto.core.dto.base.BaseDto;
import com.petto.core.model.base.BaseEntity;

public interface AbstractMapper<E extends BaseEntity, DTO extends BaseDto> {

  E mapToEntity(DTO dto);

  DTO mapToDto(E entity);
}
