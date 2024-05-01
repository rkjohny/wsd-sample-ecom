package com.wsd.ecom.dto.types;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TopItemByQuantity implements Serializable {
    private Long itemId;
    private String name;
    private long totalSales;
}
