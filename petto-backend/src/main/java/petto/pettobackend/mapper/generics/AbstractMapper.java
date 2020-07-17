package petto.pettobackend.mapper.generics;

import petto.pettobackend.dto.base.BaseDto;
import petto.pettobackend.model.base.BaseDocument;

public interface AbstractMapper<D extends BaseDocument, DTO extends BaseDto> {

  D mapToDocument(DTO dto);

  DTO mapToDto(D document);

  DTO mapToParentDto(DTO dto);
}
