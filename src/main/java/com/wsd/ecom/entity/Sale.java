package com.wsd.ecom.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "t_sale")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@JsonIgnoreProperties(value = { "customer" }, allowSetters = true, allowGetters = false)
public class Sale extends AbstractAuditingEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @NotNull
    @ManyToOne(optional = false)
    protected Item item;

    @NotNull
    @Column(name = "quantity")
    protected Long quantity;

    @NotNull
    @Column(name = "amount")
    protected Double amount;

    @NotNull
    @ManyToOne(optional = false)
    protected User customer;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
}
