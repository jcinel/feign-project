package com.example.cats.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class FactsDTO {

    @JsonProperty("_id")
    public String factID;

    @JsonProperty("_v")
    public int v;

    @JsonProperty("user")
    public String userID;

    @JsonProperty("text")
    public String fact;
}
