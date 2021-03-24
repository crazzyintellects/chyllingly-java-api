package com.restaurant.chyllingly.controller;

import com.restaurant.chyllingly.exception.APIException;
import com.restaurant.chyllingly.service.RestaurantMenuService;
import com.restaurant.chyllingly.service.dto.MenuDTO;
import com.restaurant.chyllingly.service.dto.RestaurantDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping(path = "/chyllingly/v1")
@CrossOrigin("http://localhost:3000")
public class RestaurantMenuController {

    @Autowired
    private RestaurantMenuService restaurantMenuService;

    private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantMenuController.class);


    /**
     * Lookup page of locations for the restaurant.
     *
     * @return List of restaurant locations as DTOs
     */
    @GetMapping(path = "/locations")
    public ResponseEntity<List<RestaurantDTO>> getAllRestaurantLocations() {
        LOGGER.info("GET list of restaurant locations");
        List<RestaurantDTO> restaurants = restaurantMenuService.getAllRestaurantLocations();
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    /**
     * Get all the menus for a particular restaurant location.
     *
     * @return List of Menus as DTOs
     */

    @GetMapping("/locations/{id}/menus")
    public ResponseEntity<List<MenuDTO>> getMenus(@PathVariable("id") Integer id) {

        LOGGER.info("GET list of menu for location" + id);
        try {
            List<MenuDTO> menus = restaurantMenuService.getMenusByRestaurantId(id);
            return new ResponseEntity<>(menus, HttpStatus.OK);

        } catch (APIException ex) {
            LOGGER.error("Unable to fetch Menus", ex);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }


    }

    /**
     * Get all the menus for a particular restaurant location.
     *
     * @return List of Menus as DTOs
     */

    @GetMapping("/menus/{id}/items")
    public ResponseEntity<MenuDTO> getMenuItems(@PathVariable("id") Integer id) {
        try {
            MenuDTO menu = restaurantMenuService.getMenuItemsByMenuId(id);
            return new ResponseEntity<>(menu, HttpStatus.OK);
        } catch (APIException ex) {
            LOGGER.error("Unable to fetch items", ex);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }

    }


}
