package com.wsd.ecom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaxSaleDayDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Instant date;
    private Double total;
}
