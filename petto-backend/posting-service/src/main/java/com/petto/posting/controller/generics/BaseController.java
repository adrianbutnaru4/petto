package com.petto.posting.controller.generics;

import com.petto.posting.dto.base.BaseDto;
import com.petto.posting.exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.Serializable;
import java.util.List;

// TODO: add validation
public abstract class BaseController<DTO extends BaseDto, ID extends Serializable>
    implements AbstractController<DTO, ID> {

  @GetMapping("/findAll")
  public List<DTO> findAll() {
    return getService().findAll();
  }

  @GetMapping("{id}")
  public DTO findById(@PathVariable("id") ID id) {
    try {
      return getService().findById(id);
    } catch (EntityNotFoundException e) {
      throw new ResponseStatusException(
          HttpStatus.NOT_FOUND, String.format("Entity with id '%s' was not found.", id), e);
    }
  }

  @PutMapping("{id}/update")
  public DTO update(@PathVariable("id") ID id, @RequestBody DTO dto) {
    if (getService().exists(id)) {
      dto.setId((Long) id);
      return getService().save(dto);
    } else {
      // TODO: properly handle this
      throw new EntityNotFoundException();
    }
  }

  @DeleteMapping("{id}/delete")
  public void delete(@PathVariable("id") ID id) {
    try {
      getService().delete(id);
    } catch (EntityNotFoundException e) {
      throw new ResponseStatusException(
          HttpStatus.NOT_FOUND, String.format("Entity with id '%s' was not found.", id), e);
    }
  }
}
