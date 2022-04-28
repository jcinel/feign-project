package com.example.cats.Client;

import com.example.cats.DTO.PostDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "post", url = "https://cat-fact.herokuapp.com")
public interface PostClient {
    @GetMapping(value = "/posts")
    List<PostDTO> getAllPosts();
}
