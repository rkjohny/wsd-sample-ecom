package com.wsd.ecom.core;

import com.wsd.ecom.dto.types.PurchaseInput;
import com.wsd.ecom.dto.types.PurchaseOutput;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderApi {
    private final ObjectProvider<PurchaseHelper> purchaseHelperObjectProvider;

    public PurchaseOutput placeOrder(PurchaseInput input) {
        PurchaseHelper helper = purchaseHelperObjectProvider.getObject();
        return helper.executeHelper(input);
    }
}
