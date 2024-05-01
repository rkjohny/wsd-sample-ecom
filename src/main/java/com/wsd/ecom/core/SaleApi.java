package com.wsd.ecom.core;


import com.wsd.ecom.dto.types.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class SaleApi {
    private final ObjectProvider<TotalSaleOfCurrentDateHelper> totalSaleOfCurrentDateHelperProvider;
    private final ObjectProvider<GetMaxSaleDayHelper> getMaxSaleDayHelperProvider;
    private final ObjectProvider<GetTopSellingItemByPriceHelper> getTopSellingItemByPriceHelperProvider;
    private final ObjectProvider<GetTopSellingItemByQuantityHelper> getTopSellingItemByQuantityHelperProvider;

    public TotalSaleOfCurrentDateOutput getTotalSaleAmountOfCurrentDate() {
        TotalSaleOfCurrentDateInput input = new TotalSaleOfCurrentDateInput();
        TotalSaleOfCurrentDateHelper helper = totalSaleOfCurrentDateHelperProvider.getObject();
        TotalSaleOfCurrentDateOutput output = helper.executeHelper(input);
        return output;
    }

    public GetMaxSaleDayOutput getMaxSaleDay(GetMaxSaleDayInput input) {
        GetMaxSaleDayHelper helper = getMaxSaleDayHelperProvider.getObject();
        return helper.executeHelper(input);
    }

    public GetTopSellingItemByPriceOutput getTop5SellingItemByAmount() {
        GetTopSellingItemByPriceInput input = new GetTopSellingItemByPriceInput();
        GetTopSellingItemByPriceHelper helper = getTopSellingItemByPriceHelperProvider.getObject();
        return helper.executeHelper(input);
    }

    public GetTopSellingItemByQuantityOutput getTop5SellingItemInLastMonthByQuantity() {
        GetTopSellingItemByQuantityInput input = new GetTopSellingItemByQuantityInput();
        GetTopSellingItemByQuantityHelper helper = getTopSellingItemByQuantityHelperProvider.getObject();
        return helper.executeHelper(input);
    }
}
