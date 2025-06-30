package com.scaler.bookmyshow.DTOS;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class SeatPosition {
    private Integer rowNo;
    private Integer columnNo;
}
