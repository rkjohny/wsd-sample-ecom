package com.wsd.ecom.dto.types;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ViewCartOutput extends AbstractOutput {

    private Double totalAmount = 0D;
    private List<ItemInViewCart> items = new ArrayList<>();
}
