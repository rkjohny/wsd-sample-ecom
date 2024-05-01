package com.wsd.ecom.dto.types;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GetTopSellingItemByPriceOutput extends AbstractOutput {
    List<TopItemByAmount> topItems = new ArrayList<>();
}
