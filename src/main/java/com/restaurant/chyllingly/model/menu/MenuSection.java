package com.restaurant.chyllingly.model.menu;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "menu")
@EqualsAndHashCode(exclude = "menu")
@Getter
@Setter
@Entity
public class MenuSection implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer menuSectionId;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 2000)
    private String description;

    @OneToMany(mappedBy = "menuSection", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MenuItem> menuItems;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    @JsonIgnore
    private Menu menu;
}
