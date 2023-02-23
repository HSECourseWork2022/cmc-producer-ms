package dev.hse.cmc.api;

import dev.hse.cmc.response.CryptoCurrencyData;
import dev.hse.cmc.response.RootResponseData;
import dev.hse.cmc.utils.ServiceConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j(topic = ServiceConstants.LOG_TOPIC)
@RequiredArgsConstructor
public class CoinMarketCapService {

    @Autowired
    private final CoinMarketCapClient coinMarketCapClient;

    public CryptoCurrencyData getQuotes() {
        RootResponseData quotes = tryGetQuotes();
        return quotes.getData().entrySet()
            .stream()
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Failed to get quotes data"))
            .getValue();
    }

    private RootResponseData tryGetQuotes() {
        try {
            return coinMarketCapClient.getQuotes();
        } catch (Exception e) {
            log.error("Failed to fetch data: " + e.getMessage());
            throw e;
        }
    }

}
