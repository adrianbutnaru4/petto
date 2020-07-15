package petto.pettobackend.controller.generics;

import petto.pettobackend.dto.BaseDto;
import petto.pettobackend.model.BaseDocument;
import petto.pettobackend.service.generics.AbstractService;

import java.io.Serializable;

public interface AbstractController<DTO extends BaseDto, ID extends Serializable> {

  AbstractService<? extends BaseDocument, DTO, ID> getService();
}
