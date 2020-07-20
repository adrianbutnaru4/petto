package petto.pettobackend.service.generics;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import petto.pettobackend.dto.base.BaseDto;
import petto.pettobackend.exceptionhandling.exceptions.EntityNotFoundException;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.model.base.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public interface AbstractService<
    E extends BaseEntity, DTO extends BaseDto, ID extends Serializable> {

  @Transactional()
  default DTO save(DTO dto) {
    E entity = getMapper().mapToEntity(dto);
    entity = getRepository().save(entity);
    return getMapper().mapToDto(entity);
  }

  default List<DTO> findAll() {
    List<E> entities =
        StreamSupport.stream(getRepository().findAll().spliterator(), false)
            .collect(Collectors.toList());
    return entities.stream().map(getMapper()::mapToDto).collect(Collectors.toList());
  }

  default DTO findById(ID id) {
    E entity = getRepository().findById(id).orElseThrow(EntityNotFoundException::new);
    return getMapper().mapToDto(entity);
  }

  default boolean exists(ID id) {
    return getRepository().existsById(id);
  }

  @Transactional()
  default void delete(ID id) {
    getRepository()
        .findById(id)
        .ifPresentOrElse(
            getRepository()::delete,
            () -> {
              throw new EntityNotFoundException();
            });
  }

  CrudRepository<E, ID> getRepository();

  AbstractMapper<E, DTO> getMapper();
}
