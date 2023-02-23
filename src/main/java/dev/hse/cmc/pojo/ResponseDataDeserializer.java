package dev.hse.cmc.pojo;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class ResponseDataDeserializer extends JsonDeserializer<ResponseData> {

    @Override
    public ResponseData deserialize(JsonParser jsonParser,
        DeserializationContext deserializationContext) throws IOException, JacksonException {
        ObjectCodec codec = jsonParser.getCodec();
        TreeNode data = codec.readTree(jsonParser).get("data");
        String symbol = data.fieldNames().next();
        TreeNode responseDataSerialized = data.get(symbol);
//        System.out.println(responseDataSerialized.toString());
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(responseDataSerialized.toString(), ResponseData.class);
    }
}
