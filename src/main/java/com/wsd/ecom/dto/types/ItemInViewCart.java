package com.wsd.ecom.dto.types;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class ItemInViewCart implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String name;

    private Long itemId;

    private long quantity;

    private Double unitPrice;

    private Double amount;
}
