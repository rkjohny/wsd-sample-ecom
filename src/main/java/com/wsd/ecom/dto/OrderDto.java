package com.wsd.ecom.dto;

import com.wsd.ecom.entity.Order;
import com.wsd.ecom.entity.Sale;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private Double amount;
    private UserDto customer;
    private List<SaleDto> sales;

    public OrderDto(Order order) {
        this.id = order.getId();
        this.amount = order.getAmount();
        this.customer = new UserDto(order.getCustomer());
        this.sales = order.getSales().stream().map(SaleDto::new).collect(Collectors.toList());
    }
}
