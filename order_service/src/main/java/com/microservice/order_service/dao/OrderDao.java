package com.microservice.order_service.dao;

import com.microservice.order_service.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order,Integer> {

}
