package com.petto.core.client;

import com.petto.core.dto.post.PostDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "petto-posting-service")
public interface PettoPostingClient {

  @RequestMapping(method = RequestMethod.POST, value = "/posts/save", consumes = "application/json")
  PostDto save(@RequestBody PostDto postDto);
}
