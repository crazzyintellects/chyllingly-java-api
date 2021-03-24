package com.restaurant.chyllingly.service;

import com.restaurant.chyllingly.exception.APIException;
import com.restaurant.chyllingly.service.dto.MenuDTO;

import com.restaurant.chyllingly.service.dto.RestaurantDTO;

import java.util.List;

public interface RestaurantMenuService {

    public List<RestaurantDTO> getAllRestaurantLocations();

    public List<MenuDTO> getMenusByRestaurantId(Integer restaurantId) throws APIException;

    public MenuDTO getMenuItemsByMenuId(Integer menuId) throws APIException;

    //Other Available operations for the API
/*
    public boolean addRestaurantLocation(RestaurantDTO restaurantDTO);
    public boolean addMenu(MenuDTO menuDTO);
    public boolean addMenuSection(MenuSectionDTO menuSectionDTO);
    public boolean addMenuItem(MenuItemDTO menuItemDTO);
    public boolean updateMenuItemPrice(BigDecimal price);
    public boolean updateItemAvailable(boolean isAvailable); */


}
