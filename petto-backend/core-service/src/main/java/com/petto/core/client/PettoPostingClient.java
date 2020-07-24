package com.petto.core.client;

import com.petto.core.dto.adoptionsource.post.PostDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "petto-posting-service")
public interface PettoPostingClient {

  @PostMapping("/posts/save}")
  PostDto save(@RequestBody PostDto postDto);
}
