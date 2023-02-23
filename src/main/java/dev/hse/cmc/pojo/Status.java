package dev.hse.cmc.pojo;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Status {

    public Date timestamp;
    public int error_code;
    public String error_message;
    public int elapsed;
    public int credit_count;
}
