package com.wsd.ecom.dto.types;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public class ItemInCart implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long itemId;

    private int quantity;
}
