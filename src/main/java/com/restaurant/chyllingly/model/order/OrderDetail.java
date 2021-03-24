package com.restaurant.chyllingly.model.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.restaurant.chyllingly.model.menu.MenuItem;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


@NoArgsConstructor
@EqualsAndHashCode(exclude = {"order", "menuitem"})
@Getter
@Setter
@Entity
public class OrderDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderDetailId;

    @ManyToOne
    @JoinColumn(name = "orderid")
    @JsonIgnore
    private Order order;

    public OrderDetail(Order order, MenuItem menuItem, Integer quantity, BigDecimal subTotalPrice) {
        this.order = order;
        this.menuItem = menuItem;
        this.quantity = quantity;
        this.subTotalPrice = subTotalPrice;
    }

    @ManyToOne
    @JoinColumn(name = "menuitemid")
    @JsonIgnore
    private MenuItem menuItem;

    private Integer quantity;
    private BigDecimal subTotalPrice;
}
