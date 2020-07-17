package petto.pettobackend.controller.generics;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import petto.pettobackend.dto.base.BaseDto;
import petto.pettobackend.exceptionhandling.exceptions.DocumentNotFoundException;

import java.io.Serializable;
import java.util.List;

// TODO: validate path variables and request bodies
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
    } catch (DocumentNotFoundException e) {
      throw new ResponseStatusException(
          HttpStatus.NOT_FOUND, String.format("Document with id '%s' was not found.", id), e);
    }
  }

  @PostMapping(value = "/save")
  @ResponseStatus(HttpStatus.CREATED)
  public DTO save(@RequestBody DTO dto) {
    return getService().save(dto);
  }

  @PutMapping("{id}/update")
  public DTO update(@PathVariable("id") ID id, @RequestBody DTO dto) {
    if (getService().exists(id)) {
      dto.setId((String) id);
      return getService().save(dto);
    } else {
      // TODO: properly handle this
      throw new DocumentNotFoundException();
    }
  }

  @DeleteMapping("{id}/delete")
  public void delete(@PathVariable("id") ID id) {
    try {
      getService().delete(id);
    } catch (DocumentNotFoundException e) {
      throw new ResponseStatusException(
          HttpStatus.NOT_FOUND, String.format("Document with id '%s' was not found.", id), e);
    }
  }
}
