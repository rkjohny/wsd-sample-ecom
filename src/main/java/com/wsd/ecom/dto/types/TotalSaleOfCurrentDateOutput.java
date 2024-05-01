package com.wsd.ecom.dto.types;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TotalSaleOfCurrentDateOutput extends AbstractOutput {
    private Double amount = 0D;
}
