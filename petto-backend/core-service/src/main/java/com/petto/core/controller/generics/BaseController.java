package com.petto.core.controller.generics;

import com.petto.core.dto.base.BaseDto;
import com.petto.core.exceptionhandling.exceptions.EntityNotFoundException;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

// TODO: add validation
public abstract class BaseController<DTO extends BaseDto, ID extends Serializable>
    implements AbstractController<DTO, ID> {

  // TODO: add pagination
  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "get all")})
  @GetMapping("/findAll")
  public List<DTO> findAll() {
    return getService().findAll();
  }

  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "get by id"),
        @ApiResponse(responseCode = "404", description = "not found")
      })
  @GetMapping("{id}")
  public ResponseEntity<DTO> findById(@PathVariable("id") ID id) {
    try {
      return ResponseEntity.ok(getService().findById(id));
    } catch (EntityNotFoundException e) {
      return ResponseEntity.notFound().build();
    }
  }

  @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "create")})
  @PostMapping(value = "/save")
  public DTO save(@RequestBody DTO dto) {
    return getService().save(dto);
  }

  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "update"),
        @ApiResponse(responseCode = "404", description = "not found")
      })
  @PutMapping("{id}/update")
  public ResponseEntity<DTO> update(@PathVariable("id") ID id, @RequestBody DTO dto) {
    if (getService().exists(id)) {
      dto.setId((Long) id);
      return ResponseEntity.ok(getService().save(dto));
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "delete"),
        @ApiResponse(responseCode = "404", description = "not found")
      })
  @DeleteMapping("{id}/delete")
  public ResponseEntity<Void> delete(@PathVariable("id") ID id) {
    try {
      getService().delete(id);
      return new ResponseEntity<>(HttpStatus.OK);
    } catch (EntityNotFoundException e) {
      return ResponseEntity.notFound().build();
    }
  }
}
