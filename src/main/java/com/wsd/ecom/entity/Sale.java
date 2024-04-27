package com.wsd.ecom.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Setter
@Getter
@Entity
@Table(name = "t_sale", indexes = {
        @Index(columnList = "created_by"),
        @Index(columnList = "last_modified_by"),
        @Index(columnList = "created_date"),
        @Index(columnList = "last_modified_date")
})
@MappedSuperclass
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@JsonIgnoreProperties(value = { "customer" }, allowSetters = true, allowGetters = false)
public class Sale extends AbstractAuditingEntity {
    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Item item;

    @NotNull
    @Column(name = "quantity")
    private Long quantity;

    @NotNull
    @Column(name = "amount")
    private Double amount;

    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User customer;

    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

}
