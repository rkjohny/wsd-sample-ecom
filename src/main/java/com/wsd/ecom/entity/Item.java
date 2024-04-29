package com.wsd.ecom.entity;

import com.wsd.ecom.config.Constants;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "t_item")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Item extends AbstractAuditingEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "name", nullable = false, unique = true)
    @Size(min = 3, max = Constants.MAX_ITEM_NAME_LENGTH)
    @ColumnDefault("''")
    private String name;

    @Column(name = "unit_price", nullable = false)
    private Double unitPrice = 0D;

    @Column(name = "unit", nullable = false)
    @ColumnDefault("''")
    private String unit;

    @Column(name = "currency", nullable = false)
    @ColumnDefault("''")
    private String currency;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    public Item name(String name) {
        this.name = name;
        return this;
    }

    public Item unitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
        return this;
    }

    public Item unit(String unit) {
        this.unit = unit;
        return this;
    }

    public Item currency(String currency) {
        this.currency = currency;
        return this;
    }

    public Item description(String description) {
        this.description = description;
        return this;
    }
}
