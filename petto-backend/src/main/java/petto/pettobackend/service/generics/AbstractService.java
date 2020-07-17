package petto.pettobackend.service.generics;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;
import petto.pettobackend.dto.base.BaseDto;
import petto.pettobackend.exceptionhandling.exceptions.DocumentNotFoundException;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.model.base.BaseDocument;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public interface AbstractService<
    D extends BaseDocument, DTO extends BaseDto, ID extends Serializable> {

  @Transactional()
  default DTO save(DTO dto) {
    D document = getMapper().mapToDocument(dto);
    document = getRepository().save(document);
    return getMapper().mapToDto(document);
  }

  default List<DTO> findAll() {
    List<D> documents = getRepository().findAll();
    return documents.stream().map(getMapper()::mapToDto).collect(Collectors.toList());
  }

  default DTO findById(ID id) {
    D d = getRepository().findById(id).orElseThrow(DocumentNotFoundException::new);
    return getMapper().mapToDto(d);
  }

  @Transactional()
  default void delete(ID id) {
    getRepository()
        .findById(id)
        .ifPresentOrElse(
            getRepository()::delete,
            () -> {
              throw new DocumentNotFoundException();
            });
  }

  MongoRepository<D, ID> getRepository();

  AbstractMapper<D, DTO> getMapper();
}
