package petto.pettobackend.service.generics;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;
import petto.pettobackend.dto.BaseDto;
import petto.pettobackend.mapper.generic.AbstractMapper;
import petto.pettobackend.model.BaseDocument;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public interface AbstractService<
    D extends BaseDocument, DTO extends BaseDto, id extends Serializable> {

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

  default DTO findById(id id) {
    D d = getRepository().findById(id).orElse(null);
    return getMapper().mapToDto(d);
  }

  @Transactional()
  default void delete(id id) {
    D d = getRepository().findById(id).orElse(null);
    getRepository().delete(d);
  }

  MongoRepository<D, id> getRepository();

  AbstractMapper<D, DTO> getMapper();
}
