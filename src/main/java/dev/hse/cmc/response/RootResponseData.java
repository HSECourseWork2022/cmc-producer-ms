package dev.hse.cmc.response;


import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RootResponseData {

    private Map<String, CryptoCurrencyData> data;

    private Status status;

}
