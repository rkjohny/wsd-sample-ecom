package com.wsd.ecom.domain;

import com.wsd.ecom.config.Constants;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "t_item", indexes = {
        @Index(columnList = "created_by"),
        @Index(columnList = "last_modified_by")
})
public class Item extends AbstractAuditingEntity {
    @Column(name = "name", nullable = false, length = Constants.MAX_ITEM_NAME_LENGTH)
    @ColumnDefault("''")
    private String name;

    @Column(name = "unit_price", nullable = false)
    private Double unitPrice = 0D;

    @Column(name = "unit", nullable = false)
    @ColumnDefault("''")
    private String unit;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", unit='" + unit + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
