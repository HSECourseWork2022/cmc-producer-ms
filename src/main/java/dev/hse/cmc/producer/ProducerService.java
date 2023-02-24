package dev.hse.cmc.producer;

import dev.hse.cmc.api.CoinMarketCapService;
import dev.hse.cmc.kafka.KafkaProducerService;
import dev.hse.cmc.response.CryptoCurrencyData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j(topic = "[template][producer][service]")
@Service
@RequiredArgsConstructor
public class ProducerService {

    private static final long INITIAL_DELAY_IN_MILLISECONDS = 1000;
    private final KafkaProducerService kafkaProducerService;
    private final CoinMarketCapService coinMarketCapService;

    @Scheduled(initialDelay = INITIAL_DELAY_IN_MILLISECONDS, fixedDelayString = "${interval}")
    public void produceScheduled() {
        produce();
    }

    public void produce() {
        CryptoCurrencyData quotes = coinMarketCapService.getQuotes();
        kafkaProducerService.send(quotes);
    }

}
