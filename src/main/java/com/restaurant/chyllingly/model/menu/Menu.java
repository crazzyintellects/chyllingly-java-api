package com.restaurant.chyllingly.model.menu;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "restaurant")
@EqualsAndHashCode(exclude = "restaurant")
@Getter
@Setter
@Entity
public class Menu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer menuId;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 2000, nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @JsonIgnore
    private Restaurant restaurant;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<MenuSection> menuSections;
}
