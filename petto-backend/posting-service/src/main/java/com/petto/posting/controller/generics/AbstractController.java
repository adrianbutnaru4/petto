package com.petto.posting.controller.generics;

import com.petto.posting.dto.base.BaseDto;
import com.petto.posting.model.base.BaseEntity;
import com.petto.posting.service.generics.AbstractService;

import java.io.Serializable;

public interface AbstractController<DTO extends BaseDto, ID extends Serializable> {

  AbstractService<? extends BaseEntity, DTO, ID> getService();
}
