package com.wsd.ecom.core;

import com.wsd.ecom.service.SaleService;
import com.wsd.ecom.dto.types.GetTopSellingItemByPriceInput;
import com.wsd.ecom.dto.types.GetTopSellingItemByPriceOutput;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Scope("prototype")
@RequiredArgsConstructor
public class GetTopSellingItemByPriceHelper extends AbstractHelper<GetTopSellingItemByPriceInput, GetTopSellingItemByPriceOutput>{
    private final SaleService saleService;

    @Override
    protected void validateInput(GetTopSellingItemByPriceInput input, Object... args) {

    }

    @Override
    protected void checkPermission(GetTopSellingItemByPriceInput input, Object... args) {

    }

    @Override
    protected GetTopSellingItemByPriceOutput executeHelper(GetTopSellingItemByPriceInput input, Object... args) {
        return saleService.getTop5SellingItemByAmount();
    }
}
