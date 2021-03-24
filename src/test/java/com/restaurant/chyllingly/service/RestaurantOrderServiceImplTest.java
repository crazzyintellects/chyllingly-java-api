package com.restaurant.chyllingly.service;


import com.restaurant.chyllingly.model.order.Order;
import com.restaurant.chyllingly.repository.order.OrderRepository;
import com.restaurant.chyllingly.service.dto.MenuItemDTO;
import com.restaurant.chyllingly.service.dto.OrderDTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import static org.mockito.Matchers.any;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class RestaurantOrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private RestaurantOrderServiceImpl restaurantOrderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
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

        Order entity = new Order();
        entity.setCustomerEmail("sir@test.com");
        entity.setCustomerName("Sir D");
        entity.setTotalPrice(new BigDecimal(3899));
        entity.setOrderId("bde36yh");
        entity.setCustomerName("sir@test.com");

        when(orderRepository.save(any(Order.class))).thenReturn(entity);
        String id = restaurantOrderService.createOrder(orderDTO);

        assertNotNull(id);

    }
}