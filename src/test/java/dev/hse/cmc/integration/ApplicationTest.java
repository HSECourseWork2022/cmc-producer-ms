package dev.hse.cmc.integration;

import dev.hse.cmc.api.CoinMarketCapService;
import dev.hse.cmc.integration.common.AbstractIntegrationTest;
import dev.hse.cmc.integration.common.TestConstants;
import dev.hse.cmc.kafka.KafkaProducerService;
import dev.hse.cmc.producer.ProducerService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

public class ApplicationTest extends AbstractIntegrationTest {

    @MockBean
    private KafkaProducerService kafkaProducerService;
    @MockBean
    private CoinMarketCapService coinMarketCapService;
    @Autowired
    private ProducerService producerService;

    @Test
    void testKafkaInteraction() {
        Mockito.when(coinMarketCapService.getQuotes()).thenReturn(TestConstants.TEST_RAW_DATA);
        producerService.produce();
        Mockito.verify(kafkaProducerService).send(TestConstants.TEST_RAW_DATA);
    }

}
