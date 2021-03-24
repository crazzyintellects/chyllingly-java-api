package com.restaurant.chyllingly.model.menu;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity
public class Restaurant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer restaurantId;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 2000, nullable = false)
    private String location;

    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Menu> menu;

}
