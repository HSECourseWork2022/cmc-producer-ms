package dev.hse.cmc.producer;

import dev.hse.cmc.api.ClientConfiguration;
import dev.hse.cmc.api.CoinMarketCapClient;
import dev.hse.cmc.kafka.KafkaProducerService;
import dev.hse.cmc.pojo.CryptocurrencyFiltered;
import dev.hse.cmc.pojo.ResponseData;
import feign.Feign;
import java.time.ZoneId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j(topic = "[template][producer][service]")
@Service
@RequiredArgsConstructor
public class ProducerService {

    private static final long INITIAL_DELAY_IN_MILLISECONDS = 1000;
    @Autowired
    private final CoinMarketCapClient client;
    private final KafkaProducerService kafkaProducerService;

    @Scheduled(initialDelay = INITIAL_DELAY_IN_MILLISECONDS, fixedDelayString = "${interval}")
    public void produceScheduled() {
        produce();
    }

    public void produce() {
        try {
            ResponseData quotes = client.getQuotes();

            CryptocurrencyFiltered filtered = CryptocurrencyFiltered.builder()
                .symbol(quotes.getSymbol())
                .vendor(1L)
                .observedAt(
                    quotes.getQuote().uSD.getLast_updated().toInstant().atZone(ZoneId.of("UTC+3"))
                        .toLocalDateTime())
                .maxSupply((long) quotes.getMax_supply())
                .circulatingSupply((long) quotes.getTotal_supply())
                .priceUSD(quotes.getQuote().getUSD().getPrice())
                .volume24h(quotes.getQuote().uSD.getVolume_24h())
                .marketCap((Double) quotes.getSelf_reported_market_cap())
                .build();
            log.info(filtered.toString());

        } catch (Exception e) {
            log.error(e.getMessage());
        }
//        kafkaProducerService.send(vendorService.fetchData());
    }

}
