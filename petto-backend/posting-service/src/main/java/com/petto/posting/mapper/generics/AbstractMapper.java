package com.petto.posting.mapper.generics;

import com.petto.posting.dto.base.BaseDto;
import com.petto.posting.model.base.BaseEntity;

public interface AbstractMapper<E extends BaseEntity, DTO extends BaseDto> {

  E mapToEntity(DTO dto);

  DTO mapToDto(E entity);
}
