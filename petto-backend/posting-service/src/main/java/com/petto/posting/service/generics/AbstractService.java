package com.petto.posting.service.generics;

import com.petto.posting.dto.base.BaseDto;
import com.petto.posting.exceptions.EntityNotFoundException;
import com.petto.posting.mapper.generics.AbstractMapper;
import com.petto.posting.model.base.BaseEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

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

  PagingAndSortingRepository<E, ID> getRepository();

  AbstractMapper<E, DTO> getMapper();
}
