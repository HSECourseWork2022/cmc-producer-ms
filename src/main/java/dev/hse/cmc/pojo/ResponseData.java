package dev.hse.cmc.pojo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//public class TemplateRaw {
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC+3")
//    LocalDateTime timestamp;
//    Long sourceId;
//    Long matchedId;
//    Double price;
//}


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonDeserialize(using = ResponseDataDeserializer.class)
public class ResponseData {

    private int id;
    private String name;
    private String symbol;
    private String slug;
    private int is_active;
    private int is_fiat;
    private int circulating_supply;
    private int total_supply;
    private int max_supply;
    private Date date_added;
    private int num_market_pairs;
    private int cmc_rank;
    private Date last_updated;
    private ArrayList<String> tags;
    private Object platform;
    private Object self_reported_circulating_supply;
    private Object self_reported_market_cap;
    private Quote quote;
}
