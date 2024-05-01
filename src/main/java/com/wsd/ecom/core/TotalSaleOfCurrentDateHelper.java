package com.wsd.ecom.core;

import com.wsd.ecom.service.SaleService;
import com.wsd.ecom.dto.types.TotalSaleOfCurrentDateInput;
import com.wsd.ecom.dto.types.TotalSaleOfCurrentDateOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Scope("prototype")
@RequiredArgsConstructor
public class TotalSaleOfCurrentDateHelper extends AbstractHelper <TotalSaleOfCurrentDateInput, TotalSaleOfCurrentDateOutput> {
    private final SaleService saleService;

    @Override
    protected void validateInput(TotalSaleOfCurrentDateInput input, Object... args) {

    }

    @Override
    protected void checkPermission(TotalSaleOfCurrentDateInput input, Object... args) {

    }

    @Override
    protected TotalSaleOfCurrentDateOutput executeHelper(TotalSaleOfCurrentDateInput input, Object... args) {
        TotalSaleOfCurrentDateOutput output = new TotalSaleOfCurrentDateOutput();
        Double amount = saleService.getTotalSaleAmountOfCurrentDate();
        if (amount == null) amount = 0D;
        output.setAmount(amount);
        return output;
    }
}
