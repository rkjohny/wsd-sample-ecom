package com.wsd.ecom.entity;

import com.wsd.ecom.config.Constants;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.ColumnDefault;

@Setter
@Getter
@Entity
@Table(name = "t_item", indexes = {
        @Index(columnList = "created_by"),
        @Index(columnList = "last_modified_by"),
        @Index(columnList = "created_date"),
        @Index(columnList = "last_modified_date")
})
@MappedSuperclass
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Item extends AbstractAuditingEntity {
    @Column(name = "name", nullable = false, unique = true)
    @Size(min = 3, max = Constants.MAX_ITEM_NAME_LENGTH)
    @ColumnDefault("''")
    private String name;

    @Column(name = "unit_price", nullable = false)
    private Double unitPrice = 0D;

    @Column(name = "unit", nullable = false)
    @ColumnDefault("''")
    private String unit;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

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
