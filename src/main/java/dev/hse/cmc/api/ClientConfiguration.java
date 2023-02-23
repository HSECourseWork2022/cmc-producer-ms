package dev.hse.cmc.api;

import feign.Logger;
import feign.Logger.Level;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfiguration {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("X-CMC_PRO_API_KEY", "b65b1603-07ac-436c-8d0a-23b2af84ca3b");
        };
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

}
