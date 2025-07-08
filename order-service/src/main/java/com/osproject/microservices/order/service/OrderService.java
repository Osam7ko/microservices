package com.osproject.microservices.order.service;

import com.osproject.microservices.order.clint.InventoryClint;
import com.osproject.microservices.order.dto.OrderRequest;
import com.osproject.microservices.order.dto.OrderResponse;
import com.osproject.microservices.order.model.Order;
import com.osproject.microservices.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    private final InventoryClint inventoryClint;

    public void placeOrder(OrderRequest orderRequest){
        boolean inStock = inventoryClint.isInStock(orderRequest.skuCode(), orderRequest.quantity());
        if (inStock) {
            var order = mapToOrder(orderRequest);
            orderRepository.save(order);
        } else {
            throw new RuntimeException("Product with SkuCode " + orderRequest.skuCode() + "is not in stock");
        }

    }
    private static Order mapToOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());
        order.setQuantity(orderRequest.quantity());
        order.setSkuCode(orderRequest.skuCode());
        return order;
    }

    @Transactional
    public void deleteAllOrders() {
        orderRepository.deleteAll();
    }

    @Transactional
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    public List<OrderResponse> getAllOrder() {
        return orderRepository.findAll().stream()
                .map(order -> new OrderResponse(order.getId(),order.getOrderNumber(),order.getSkuCode(),order.getPrice(),order.getQuantity()))
                .toList();
    }
}
