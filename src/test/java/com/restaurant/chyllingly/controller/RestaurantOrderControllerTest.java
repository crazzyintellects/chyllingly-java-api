package com.restaurant.chyllingly.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurant.chyllingly.service.RestaurantOrderService;
import com.restaurant.chyllingly.service.dto.MenuItemDTO;
import com.restaurant.chyllingly.service.dto.OrderDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RestaurantOrderController.class)
public class RestaurantOrderControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private RestaurantOrderService restaurantOrderService;

    @InjectMocks
    private RestaurantOrderController restaurantOrderController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }

    @Test
    public void createOrderSuccess() throws Exception{
        String id = "vf47ybs688";

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

        // setup a mock response
        when(restaurantOrderService.createOrder(any(OrderDTO.class)))
                .thenReturn(id);

        String input = mapToJson(orderDTO);

        // simulate the form submit (POST)
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8090/chyllingly/v1/order")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(input)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(201, status);


    }


    @Test
    public void validateName() throws Exception{
        String id = "vf47ybs688";

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setCustomerEmail("sir@test.com");
        orderDTO.setCustomerName("");
        orderDTO.setTotalPrice(new BigDecimal(3899));
        MenuItemDTO menuItemDTO = new MenuItemDTO();
        menuItemDTO.setMenuItemId(1);
        menuItemDTO.setQuantity(1);
        List<MenuItemDTO> menuItemDTOList = new ArrayList<>();
        menuItemDTOList.add(menuItemDTO);
        orderDTO.setMenuItems(menuItemDTOList);

        // setup a mock response
        when(restaurantOrderService.createOrder(any(OrderDTO.class)))
                .thenReturn(id);

        String input = mapToJson(orderDTO);

        // simulate the form submit (POST)
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8090/chyllingly/v1/order")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(input)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(400, status);



    }
    @Test
    public void validateOrderItems() throws Exception{
        String id = "vf47ybs688";

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setCustomerEmail("sir@test.com");
        orderDTO.setCustomerName("Sir D");
        orderDTO.setTotalPrice(new BigDecimal(3899));

        List<MenuItemDTO> menuItemDTOList = new ArrayList<>();

        orderDTO.setMenuItems(menuItemDTOList);

        // setup a mock response
        when(restaurantOrderService.createOrder(any(OrderDTO.class)))
                .thenReturn(id);

        String input = mapToJson(orderDTO);

        // simulate the form submit (POST)
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:8090/chyllingly/v1/order")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(input)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(400, status);


    }

}