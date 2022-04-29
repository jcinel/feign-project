package com.example.cats.Client;

import com.example.cats.DTO.FactsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "fact", url = "https://cat-fact.herokuapp.com")
public interface FactsClient {
    @GetMapping(value = "/facts/random?amount=5")
    List<FactsDTO> getFacts();
}
