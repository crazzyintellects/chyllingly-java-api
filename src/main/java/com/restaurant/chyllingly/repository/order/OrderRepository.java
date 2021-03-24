package com.restaurant.chyllingly.repository.order;

import com.restaurant.chyllingly.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
