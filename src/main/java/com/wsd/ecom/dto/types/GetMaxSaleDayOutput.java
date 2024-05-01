package com.wsd.ecom.dto.types;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class GetMaxSaleDayOutput extends AbstractOutput {
    private LocalDate date;
    private Double amount = 0D;
}
