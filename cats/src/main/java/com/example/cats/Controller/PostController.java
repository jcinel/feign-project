package com.example.cats.Controller;

import com.example.cats.Client.PostClient;
import com.example.cats.DTO.PostDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {

    private PostClient postClient;

    @GetMapping
    public List<PostDTO> getAllPosts() {
        return postClient.getAllPosts();
    }
}
