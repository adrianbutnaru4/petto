package com.petto.core.controller;

import com.petto.core.client.PettoPostingClient;
import com.petto.core.controller.util.PatchMediaType;
import com.petto.core.dto.adoptionsource.post.BasePostDto;
import com.petto.core.dto.post.PostDto;
import com.petto.core.service.PostService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.json.JsonMergePatch;
import javax.json.JsonPatch;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping(PostController.BASE_URL)
public class PostController {

  private static final Logger LOGGER = LoggerFactory.getLogger(PostController.class);

  static final String BASE_URL = "posts";

  private final PostService postService;
  private final PettoPostingClient pettoPostingClient;

  public PostController(PostService postService, PettoPostingClient pettoPostingClient) {
    this.postService = postService;
    this.pettoPostingClient = pettoPostingClient;
  }

  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "find all")})
  @GetMapping("/findAll")
  public ResponseEntity<List<BasePostDto>> findAll() {
    LOGGER.info("find all");
    return ResponseEntity.ok(
        Optional.ofNullable(pettoPostingClient.findAll().getBody()).stream()
            .flatMap(Collection::stream)
            .map(postService::getCustomPostDto)
            .collect(Collectors.toList()));
  }

  @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "find all")})
  @GetMapping("/findAllByPageRequest")
  public ResponseEntity<List<BasePostDto>> findAllByPageRequest(
      @RequestParam(name = "page") int page,
      @RequestParam(name = "size") int size,
      @RequestParam(name = "sortDirection") String sortDirection,
      @RequestParam(name = "sort") String sort) {
    LOGGER.info("find all");
    return ResponseEntity.ok(
        Optional.ofNullable(
                pettoPostingClient.findAllByPageRequest(page, size, sortDirection, sort).getBody())
            .stream()
            .flatMap(Collection::stream)
            .map(postService::getCustomPostDto)
            .collect(Collectors.toList()));
  }

  @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "create")})
  @PostMapping(value = "/save")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<BasePostDto> save(@RequestBody PostDto postDto) {
    LOGGER.info("save: {}", postDto);
    return new ResponseEntity<>(
        postService.getCustomPostDto(pettoPostingClient.save(postDto).getBody()),
        HttpStatus.CREATED);
  }

  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "get by id"),
        @ApiResponse(responseCode = "404", description = "not found")
      })
  @GetMapping("{id}")
  public ResponseEntity<BasePostDto> findById(@PathVariable("id") Long id) {
    LOGGER.info("find: id={}", id);
    return ResponseEntity.ok(
        postService.getCustomPostDto(pettoPostingClient.findById(id).getBody()));
  }

  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "update"),
        @ApiResponse(responseCode = "404", description = "not found")
      })
  @PutMapping("{id}/update")
  public ResponseEntity<BasePostDto> update(
      @PathVariable("id") Long id, @RequestBody PostDto postDto) {
    LOGGER.info("update: id={}", id);
    return ResponseEntity.ok(
        postService.getCustomPostDto(pettoPostingClient.update(id, postDto).getBody()));
  }

  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "patch"),
        @ApiResponse(responseCode = "404", description = "not found")
      })
  @PatchMapping(path = "/{id}", consumes = PatchMediaType.APPLICATION_JSON_PATCH_VALUE)
  public ResponseEntity<BasePostDto> patch(
      @PathVariable Long id, @RequestBody JsonPatch patchDocument) {
    LOGGER.info("patch: id={}", id);
    return ResponseEntity.ok(
        postService.getCustomPostDto(pettoPostingClient.patch(id, patchDocument).getBody()));
  }

  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "merge patch"),
        @ApiResponse(responseCode = "404", description = "not found")
      })
  @PatchMapping(path = "/{id}", consumes = PatchMediaType.APPLICATION_MERGE_PATCH_VALUE)
  public ResponseEntity<BasePostDto> patch(
      @PathVariable Long id, @RequestBody JsonMergePatch mergePatchDocument) {
    LOGGER.info("merge patch: id={}", id);
    return ResponseEntity.ok(
        postService.getCustomPostDto(pettoPostingClient.patch(id, mergePatchDocument).getBody()));
  }

  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "delete"),
        @ApiResponse(responseCode = "404", description = "not found")
      })
  @DeleteMapping("{id}/delete")
  public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
    LOGGER.info("delete: id={}", id);
    return pettoPostingClient.delete(id);
  }
}
