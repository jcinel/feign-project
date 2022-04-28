package com.example.cats;

import com.example.cats.Client.FactsClient;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.mock.HttpMethod;
import feign.mock.MockClient;
import org.junit.jupiter.api.Test;
import org.springframework.cloud.openfeign.support.SpringMvcContract;

public class FactsClientTest {

    private static String BASE_URL = "https://cat-fact.herokuapp.com";

    private static String RESPONSE_FACTS = "{\n" +
            "        \"_id\": \"61dae02f3c4466aa794bae7a\",\n" +
            "        \"_v\": 0,\n" +
            "        \"user\": \"61c6591c37709f33abba8d79\",\n" +
            "        \"text\": \"A fresh fact.\"\n" +
            "    }";

    private FactsClient factsClient;

    @Test
    public void whenGetFactsClientReturnOk(){
        this.builderFeignClient(new MockClient().ok(
                HttpMethod.GET,
                BASE_URL.concat("/facts"),
                RESPONSE_FACTS
        ));
    }

    private void builderFeignClient(MockClient mockClient){
        factsClient = Feign.builder()
                .client(mockClient)
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .contract(new SpringMvcContract())
                .target(FactsClient.class, BASE_URL);
    }
}
