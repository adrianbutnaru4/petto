package petto.pettobackend.controller.generics;

import org.springframework.web.bind.annotation.*;
import petto.pettobackend.dto.BaseDto;
import petto.pettobackend.model.BaseDocument;

import java.io.Serializable;
import java.util.List;

public abstract class BaseController<
        D extends BaseDocument, DTO extends BaseDto, ID extends Serializable>
    implements AbstractController<D, DTO, ID> {

  @GetMapping("/findAll")
  public List<DTO> findAll() {
    return getService().findAll();
  }

  @GetMapping("{id}")
  public DTO findById(@PathVariable("id") ID id) {
    return id != null ? getService().findById(id) : null;
  }

  @PostMapping(value = "/save")
  public DTO save(@ModelAttribute DTO dto) {
    return getService().save(dto);
  }

  @PutMapping("{id}/update")
  public DTO update(@PathVariable("id") ID id) {
    if (id != null) {
      DTO dto = getService().findById(id);
      return dto != null ? getService().save(dto) : null;
    } else {
      return null;
    }
  }

  @DeleteMapping("{id}/delete")
  public void delete(@PathVariable("id") ID id) {
    if (id != null) {
      getService().delete(id);
    }
  }
}
