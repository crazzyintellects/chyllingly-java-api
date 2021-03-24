package com.restaurant.chyllingly.repository.menu;

import com.restaurant.chyllingly.model.menu.Menu;
import com.restaurant.chyllingly.model.menu.MenuSection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuSectionRepository extends JpaRepository<MenuSection,Integer> {
    List<MenuSection> findByMenu(Menu menu);

}
