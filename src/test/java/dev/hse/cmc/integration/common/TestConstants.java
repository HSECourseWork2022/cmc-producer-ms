package dev.hse.cmc.integration.common;

import dev.hse.cmc.response.CryptoCurrencyData;
import dev.hse.cmc.response.Quote;
import dev.hse.cmc.response.USD;
import java.sql.Date;
import java.time.Instant;

public class TestConstants {

    public static final CryptoCurrencyData TEST_RAW_DATA = CryptoCurrencyData.builder()
        .symbol("symbol")
        .circulating_supply(12)
        .max_supply(13)
        .quote(Quote.builder()
            .usd(USD.builder()
                .last_updated(Date.from(Instant.now()))
                .market_cap(13)
                .price(13)
                .volume_24h(14)
                .build())
            .build())
        .total_supply(321)
        .build();

}
