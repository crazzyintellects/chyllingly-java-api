package com.restaurant.chyllingly.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurant.chyllingly.model.menu.MenuItem;
import com.restaurant.chyllingly.model.order.*;
import com.restaurant.chyllingly.repository.order.OrderRepository;
import com.restaurant.chyllingly.service.dto.MenuItemDTO;
import com.restaurant.chyllingly.service.dto.OrderDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class RestaurantOrderServiceImpl implements RestaurantOrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantOrderServiceImpl.class);
    @Autowired
    private OrderRepository orderRepository;

    private static final ObjectMapper mapper = new ObjectMapper();


    /**
     * create an order from the request
     *
     * @param orderDTO
     * @return the the order Id as String
     * @throws Exception if unable to perform creation
     */
    @Override
    public String createOrder(OrderDTO orderDTO) throws Exception {

        Order orderEntity = new Order();
        final UUID orderId = UUID.randomUUID();
        LOGGER.info("Create order : " + orderId.toString() + " : " + orderDTO.toString());

        orderEntity.setOrderId(orderId.toString());
        orderEntity.setCustomerEmail(orderDTO.getCustomerEmail());
        orderEntity.setCustomerName(orderDTO.getCustomerName());
        orderEntity.setPayment(Payment.CASH);
        orderEntity.setOrderStatus(OrderStatus.PENDING);
        orderEntity.setTotalPrice(orderDTO.getTotalPrice());
        orderEntity.setLocalDateTime(LocalDateTime.now());

        //Convert DTOs to Entity
        List<MenuItem> menuItems = new ArrayList<>();
        for (MenuItemDTO menuItemDTO : orderDTO.getMenuItems()) {
            MenuItem menuItem = mapper.convertValue(menuItemDTO, new TypeReference<MenuItem>() {
            });
            menuItems.add(menuItem);
        }

        Set<OrderDetail> orderDetails = menuItems.stream()
                .map(menuItem -> new OrderDetail(orderEntity, menuItem, menuItem.getQuantity(), menuItem.getPrice()))
                .collect(Collectors.toSet());

        orderEntity.setOrderDetails(orderDetails);
        Order savedOrderEntity = orderRepository.save(orderEntity);
        return savedOrderEntity.getOrderId();
    }

}
