package com.example.cats.Controller;

import com.example.cats.Client.FactsClient;
import com.example.cats.DTO.FactsDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/facts")
public class FactsController {

    private FactsClient postClient;

    @GetMapping
    public List<FactsDTO> getAllPosts() {
        return postClient.getAllPosts();
    }
}
