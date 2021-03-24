package com.restaurant.chyllingly.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurant.chyllingly.exception.APIException;
import com.restaurant.chyllingly.model.menu.Menu;
import com.restaurant.chyllingly.model.menu.MenuItem;
import com.restaurant.chyllingly.model.menu.MenuSection;
import com.restaurant.chyllingly.model.menu.Restaurant;
import com.restaurant.chyllingly.repository.menu.MenuItemRepository;
import com.restaurant.chyllingly.repository.menu.MenuRepository;
import com.restaurant.chyllingly.repository.menu.MenuSectionRepository;
import com.restaurant.chyllingly.repository.menu.RestaurantRepository;
import com.restaurant.chyllingly.service.dto.MenuDTO;
import com.restaurant.chyllingly.service.dto.MenuItemDTO;
import com.restaurant.chyllingly.service.dto.MenuSectionDTO;
import com.restaurant.chyllingly.service.dto.RestaurantDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class RestaurantMenuServiceImpl implements RestaurantMenuService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private MenuSectionRepository menuSectionRepositoryRepository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantMenuServiceImpl.class);


    /**
     * Get all the restaurant locations for a ordering online
     *
     * @return List of restaurant locations
     */
    @Override
    public List<RestaurantDTO> getAllRestaurantLocations() {
        return restaurantRepository.findAll().stream()
                .map(entity -> new RestaurantDTO(entity.getRestaurantId(), entity.getName(), entity.getLocation()))
                .collect(Collectors.toList());

    }

    /**
     * Get all the menus available for a particular restaurant location
     *
     * @param restaurantId
     * @return List of menus
     */
    @Override
    public List<MenuDTO> getMenusByRestaurantId(Integer restaurantId) throws APIException {

        try {
            LOGGER.info("Fetching details for Restauarnt :" + restaurantId);
            Restaurant restaurant = verifyRestaurant(restaurantId);
            List<Menu> menus = menuRepository.findByRestaurant(restaurant);

            return menus.stream()
                    .map(entity -> new MenuDTO(entity.getMenuId(), entity.getTitle(), entity.getDescription(), null))
                    .collect(Collectors.toList());


        } catch (Exception ex) {
            throw new APIException(ex.getMessage());
        }


    }

    /**
     * Get all the menu items available for a particular selected menu
     *
     * @param menuId
     * @return List of menu items with sections
     */
    @Override
    public MenuDTO getMenuItemsByMenuId(Integer menuId) throws APIException {

        try {
            LOGGER.info("Fetching details for Menu Id :" + menuId);
            Menu currentMenu = verifyMenu(menuId);
            MenuDTO menuDTO = new MenuDTO();
            menuDTO.setMenuID(currentMenu.getMenuId());

            List<MenuSectionDTO> menuSections = new ArrayList<>();
            for (MenuSection menuSection : currentMenu.getMenuSections()) {
                MenuSectionDTO menuSectionDTO = mapper.convertValue(menuSection, new TypeReference<MenuSectionDTO>() {
                });

                List<MenuItemDTO> menuItems = new ArrayList<>();
                for (MenuItem menuItem : menuSection.getMenuItems()) {
                    MenuItemDTO menuItemDTO = mapper.convertValue(menuItem, new TypeReference<MenuItemDTO>() {
                    });
                    menuItems.add(menuItemDTO);
                }
                menuSectionDTO.setMenuItems(menuItems);
                menuSections.add(menuSectionDTO);
            }

            menuDTO.setMenuSections(menuSections);
            return menuDTO;
        } catch (Exception ex) {
            throw new APIException(ex.getMessage());
        }

    }


    /**
     * Helper method to verify and return the Restaurant location for a particular restaurant Id
     *
     * @param restaurantId
     * @return the found Restaurant
     * @throws NoSuchElementException if no Restaurant found
     */
    private Restaurant verifyRestaurant(Integer restaurantId) throws NoSuchElementException {
        return restaurantRepository.findById(restaurantId).orElseThrow(() ->
                new NoSuchElementException("No Restaurant location exists for "
                        + restaurantId));
    }

    /**
     * Helper method to verify and return the menu for a particular menu Id
     *
     * @param menuId
     * @return the found menu
     * @throws NoSuchElementException if no menu found
     */
    private Menu verifyMenu(Integer menuId) throws NoSuchElementException {
        return menuRepository.findById(menuId).orElseThrow(() ->
                new NoSuchElementException("No such menu exists for "
                        + menuId));
    }


}
