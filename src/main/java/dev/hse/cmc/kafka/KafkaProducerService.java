package dev.hse.cmc.kafka;

import dev.hse.cmc.response.CryptoCurrencyData;
import dev.hse.cmc.utils.ServiceConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j(topic = ServiceConstants.LOG_TOPIC)
@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    @Value("${producer.source}.${producer.subtheme}.producers.outcome")
    private String outputTopic;
    private final KafkaTemplate<String, CryptoCurrencyData> kafkaTemplate;

    public void send(CryptoCurrencyData templateRaw) {
        log.info("Sending to '{}' topic", outputTopic);
        kafkaTemplate.send(outputTopic, templateRaw);
    }
}
