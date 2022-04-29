package com.example.cats.Config;

import com.example.cats.Error.Decoder.Decoder;
import feign.Client;
import feign.codec.ErrorDecoder;
import feign.okhttp.OkHttpClient;
import org.springframework.context.annotation.Bean;

public class FactsClientConfiguration {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new Decoder();
    }

    @Bean
    public Client feignClient() {
        return new OkHttpClient();
    }
}
