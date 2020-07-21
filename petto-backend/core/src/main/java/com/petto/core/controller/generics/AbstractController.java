package com.petto.core.controller.generics;

import com.petto.core.dto.base.BaseDto;
import com.petto.core.model.base.BaseEntity;
import com.petto.core.service.generics.AbstractService;

import java.io.Serializable;

public interface AbstractController<DTO extends BaseDto, ID extends Serializable> {

  AbstractService<? extends BaseEntity, DTO, ID> getService();
}
