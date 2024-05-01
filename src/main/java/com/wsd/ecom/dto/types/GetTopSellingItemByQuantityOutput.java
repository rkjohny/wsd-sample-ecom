package com.wsd.ecom.dto.types;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GetTopSellingItemByQuantityOutput extends AbstractOutput {
    List<TopItemByQuantity> topItems = new ArrayList<>();
}
