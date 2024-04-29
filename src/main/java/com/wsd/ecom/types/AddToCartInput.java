package com.wsd.ecom.types;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AddToCartInput extends AbstractInput implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long userId;

    private List<ItemInCart> items = new ArrayList<>();

    @Override
    public String toString() {
        return "AddToCartInput{" +
                "userId=" + userId +
                ", items=" + items +
                '}';
    }
}
