package dev.hse.cmc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "dev.hse.cmc.api")
public class CoinMarketCapProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoinMarketCapProducerApplication.class, args);
    }
}
