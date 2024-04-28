package com.wsd.ecom.dto;

import com.wsd.ecom.entity.Sale;
import com.wsd.ecom.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private ItemDto item;
    private Long quantity;
    private Double amount;
    private UserDto customer;

    public SaleDto(Sale sale) {
        this.id = sale.getId();
        this.item = new ItemDto(sale.getItem());
        this.quantity = sale.getQuantity();
        this.amount = sale.getAmount();
        this.customer = new UserDto(sale.getCustomer());
    }
}
