package com.example.cats.Controller;

import com.example.cats.DTO.FactsDTO;
import com.example.cats.Service.FactsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/facts")
public class FactsController {

    private FactsService factsService;

    @GetMapping
    public List<FactsDTO> getFacts() {
        return factsService.getFacts();
    }
}
