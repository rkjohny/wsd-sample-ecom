package com.wsd.ecom.entity.dto;

import com.wsd.ecom.entity.Item;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Double unitPrice;
    private String unit;
    private String description;

    public ItemDto(Item item) {
        this.id = item.getId();
        this.name = item.getName();
        this.unitPrice = item.getUnitPrice();
        this.unit = item.getUnit();
        this.description = item.getDescription();
    }
}
