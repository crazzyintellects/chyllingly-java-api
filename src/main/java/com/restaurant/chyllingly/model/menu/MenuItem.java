package com.restaurant.chyllingly.model.menu;


import com.fasterxml.jackson.annotation.JsonIgnore;

import com.restaurant.chyllingly.model.order.OrderDetail;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"menuSection", "orderDetails"})
@EqualsAndHashCode(exclude = {"menuSection", "orderDetails"})
@Getter
@Setter
@Entity
public class MenuItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer menuItemId;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 2000, nullable = false)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Boolean isAvailable;

    @Transient
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_section_id")
    @JsonIgnore
    private MenuSection menuSection;

    @OneToMany(
            mappedBy = "menuItem",
            cascade = CascadeType.ALL
    )
    @JsonIgnore
    private Set<OrderDetail> orderDetails;
}
