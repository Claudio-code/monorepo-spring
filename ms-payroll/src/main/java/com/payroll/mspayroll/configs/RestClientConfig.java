package com.payroll.mspayroll.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class RestClientConfig {
    @Value("${hr-worker.host}")
    private String hrWorkerHost;

    @Bean
    public RestTemplate hrWorkerRestTemplate() {
        final var defaultUriBuilderFactory = new DefaultUriBuilderFactory(hrWorkerHost);
        return new RestTemplateBuilder()
                .uriTemplateHandler(defaultUriBuilderFactory)
                .build();
    }
}
