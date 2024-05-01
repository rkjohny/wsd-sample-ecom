package com.wsd.ecom.entity.dto;

import com.wsd.ecom.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private UserDto customer;
    private List<SaleDto> sales;

    public OrderDto(Order order) {
        this.id = order.getId();
        this.customer = new UserDto(order.getCustomer());
        this.sales = order.getSales().stream().map(SaleDto::new).collect(Collectors.toList());
    }
}
