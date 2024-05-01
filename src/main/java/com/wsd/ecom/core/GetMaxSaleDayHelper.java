package com.wsd.ecom.core;

import com.wsd.ecom.service.SaleService;
import com.wsd.ecom.dto.types.GetMaxSaleDayInput;
import com.wsd.ecom.dto.types.GetMaxSaleDayOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@Scope("prototype")
@RequiredArgsConstructor
public class GetMaxSaleDayHelper extends AbstractHelper <GetMaxSaleDayInput, GetMaxSaleDayOutput>{
    private final SaleService saleService;


    @Override
    protected void validateInput(GetMaxSaleDayInput input, Object... args) {
        if (input.getStartDate() == null || input.getEndDate() == null)
            throw new IllegalArgumentException("Invalid inputs");
    }

    @Override
    protected void checkPermission(GetMaxSaleDayInput input, Object... args) {

    }

    @Override
    protected GetMaxSaleDayOutput executeHelper(GetMaxSaleDayInput input, Object... args) {
        return saleService .getMaxSaleDay(input.getStartDate(), input.getEndDate());
    }
}
