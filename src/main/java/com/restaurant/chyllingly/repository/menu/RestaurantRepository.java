package com.restaurant.chyllingly.repository.menu;

import com.restaurant.chyllingly.model.menu.Menu;
import com.restaurant.chyllingly.model.menu.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {

    List<Menu> findMenuByRestaurantId(Integer restaurantId);
}
