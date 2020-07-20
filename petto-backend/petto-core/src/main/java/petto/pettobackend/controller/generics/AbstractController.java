package petto.pettobackend.controller.generics;

import petto.pettobackend.dto.base.BaseDto;
import petto.pettobackend.model.base.BaseEntity;
import petto.pettobackend.service.generics.AbstractService;

import java.io.Serializable;

public interface AbstractController<DTO extends BaseDto, ID extends Serializable> {

  AbstractService<? extends BaseEntity, DTO, ID> getService();
}
