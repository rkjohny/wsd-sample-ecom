package com.wsd.ecom.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Getter
@Setter
@Entity
@Table(name = "t_cart_item", indexes = {
        @Index(columnList = "created_by"),
        @Index(columnList = "last_modified_by"),
        @Index(columnList = "created_date"),
        @Index(columnList = "last_modified_date")
})
@MappedSuperclass
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@JsonIgnoreProperties(value = { "customer" }, allowSetters = true, allowGetters = false)
public class CartItem extends AbstractAuditingEntity {

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
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

}
