package dev.hse.cmc.utils.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import dev.hse.cmc.response.CryptoCurrencyData;
import dev.hse.cmc.utils.ServiceConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serializer;

@Slf4j(topic = ServiceConstants.LOG_TOPIC)
public class CryptoCurrencyDataSerializer implements Serializer<CryptoCurrencyData> {

    private final JsonMapper mapper = JsonMapperUtils.getJsonMapper();

    @Override
    public byte[] serialize(String s, CryptoCurrencyData templateRaw) {
        try {
            return mapper.writeValueAsBytes(templateRaw);
        } catch (JsonProcessingException e) {
            log.error("Error occurred while serializing ", e);
            throw new RuntimeException(e);
        }
    }
}
