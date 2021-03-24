package com.restaurant.chyllingly.repository.menu;

import com.restaurant.chyllingly.model.menu.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {
}
