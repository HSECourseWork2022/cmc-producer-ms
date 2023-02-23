package dev.hse.cmc.api;

import dev.hse.cmc.response.RootResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(value = "cmc", url = "https://pro-api.coinmarketcap.com", configuration = ClientConfiguration.class)
public interface CoinMarketCapClient {

    @RequestMapping(value = "/v2/cryptocurrency/quotes/latest?id=1", method = RequestMethod.GET)
    RootResponseData getQuotes();

}
