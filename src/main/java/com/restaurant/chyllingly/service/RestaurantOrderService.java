package com.restaurant.chyllingly.service;


import com.restaurant.chyllingly.service.dto.OrderDTO;

public interface RestaurantOrderService {

    public String createOrder(OrderDTO orderDTO) throws Exception;

    //Other available operations
    /*
    public boolean updateOrder(OrderStatus orderStatus);
    public boolean updatePayment(Payment payment);*/
}
