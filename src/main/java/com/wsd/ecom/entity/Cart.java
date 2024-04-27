package com.wsd.ecom.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "t_cart", indexes = {
        @Index(columnList = "created_by"),
        @Index(columnList = "last_modified_by"),
        @Index(columnList = "created_date"),
        @Index(columnList = "last_modified_date")
})
@MappedSuperclass
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@JsonIgnoreProperties(value = { "cartItems" }, allowSetters = true, allowGetters = false)
public class Cart extends AbstractAuditingEntity {
    @NotNull
    @Column(name = "amount")
    private Double amount;

    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User customer;

    @NotNull
    @OneToMany(mappedBy = "cartItem", cascade = CascadeType.ALL)
    private List<CartItem> cartItems = new ArrayList<>();

}
