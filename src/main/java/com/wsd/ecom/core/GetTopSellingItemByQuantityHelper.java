package com.wsd.ecom.core;

import com.wsd.ecom.dto.types.GetTopSellingItemByQuantityInput;
import com.wsd.ecom.dto.types.GetTopSellingItemByQuantityOutput;
import com.wsd.ecom.service.SaleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Scope("prototype")
@RequiredArgsConstructor
public class GetTopSellingItemByQuantityHelper extends AbstractHelper <GetTopSellingItemByQuantityInput, GetTopSellingItemByQuantityOutput>{
    private final SaleService saleService;

    @Override
    protected void validateInput(GetTopSellingItemByQuantityInput input, Object... args) {

    }

    @Override
    protected void checkPermission(GetTopSellingItemByQuantityInput input, Object... args) {

    }

    @Override
    protected GetTopSellingItemByQuantityOutput executeHelper(GetTopSellingItemByQuantityInput input, Object... args) {
        return saleService.getTop5SellingItemInLastMonthByQuantity();
    }
}
