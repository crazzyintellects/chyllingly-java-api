package com.restaurant.chyllingly.service;


import com.restaurant.chyllingly.service.dto.MenuItemDTO;
import com.restaurant.chyllingly.service.dto.OrderDTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class RestaurantOrderServiceImplIntegrationTest {

    @Autowired
    private RestaurantOrderServiceImpl restaurantOrderService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void createOrderSuccess() throws Exception{

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setCustomerEmail("sir@test.com");
        orderDTO.setCustomerName("Sir D");
        orderDTO.setTotalPrice(new BigDecimal(3899));
        MenuItemDTO menuItemDTO = new MenuItemDTO();
        menuItemDTO.setMenuItemId(1);
        menuItemDTO.setQuantity(1);
        List<MenuItemDTO> menuItemDTOList = new ArrayList<>();
        menuItemDTOList.add(menuItemDTO);
        orderDTO.setMenuItems(menuItemDTOList);

        String id = restaurantOrderService.createOrder(orderDTO);

        assertNotNull(id);

    }
}
