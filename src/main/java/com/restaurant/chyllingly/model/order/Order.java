package com.restaurant.chyllingly.model.order;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
@Table(name = "Orders")
@Entity
public class Order implements Serializable {

    @Id
    private String orderId;

    @Column(nullable = false)
    private LocalDateTime LocalDateTime;

    @Column
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @Column(nullable = false, scale = 0)
    private BigDecimal totalPrice;

    public Order(String orderId, java.time.LocalDateTime localDateTime, OrderStatus orderStatus, BigDecimal totalPrice, Payment payment, String customerName, String customerEmail) {
        this.orderId = orderId;
        LocalDateTime = localDateTime;
        this.orderStatus = orderStatus;
        this.totalPrice = totalPrice;
        this.payment = payment;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
    }

    @Column
    @Enumerated(EnumType.STRING)
    private Payment payment;

    @Column
    private String customerName;

    @Column
    private String customerEmail;

    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL
    )
    private Set<OrderDetail> orderDetails;
}
