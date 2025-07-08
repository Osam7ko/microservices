package com.osproject.microservices.order.repository;

import com.osproject.microservices.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long>{
}
