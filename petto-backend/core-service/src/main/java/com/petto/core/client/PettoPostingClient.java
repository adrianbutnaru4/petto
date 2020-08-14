package com.petto.core.client;

import com.petto.core.dto.post.PostDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "petto-posting-service")
public interface PettoPostingClient {

  @GetMapping("/posts/findAll")
  ResponseEntity<List<PostDto>> findAll();

  @GetMapping("/posts/findAllByPageRequest")
  ResponseEntity<List<PostDto>> findAllByPageRequest(
      @RequestParam(name = "page") int page,
      @RequestParam(name = "size") int size,
      @RequestParam(name = "sortDirection") String sortDirection,
      @RequestParam(name = "sort") String sort);

  @GetMapping("posts/{id}")
  ResponseEntity<PostDto> findById(@PathVariable("id") Long id);

  @PostMapping("/posts/save")
  ResponseEntity<PostDto> save(@RequestBody PostDto postDto);

  @PutMapping("posts/{id}/update")
  ResponseEntity<PostDto> update(@PathVariable("id") Long id, @RequestBody PostDto postDto);

  @DeleteMapping("posts/{id}/delete")
  ResponseEntity<Void> delete(@PathVariable("id") Long id);
}
