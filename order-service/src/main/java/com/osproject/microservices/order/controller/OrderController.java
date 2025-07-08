package com.osproject.microservices.order.controller;

import com.osproject.microservices.order.dto.OrderRequest;
import com.osproject.microservices.order.dto.OrderResponse;
import com.osproject.microservices.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest){
        orderService.placeOrder(orderRequest);
        return "Order have Successfully placed";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponse> getAllOrder(){
        return orderService.getAllOrder();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllOrders(){
        orderService.deleteAllOrders();
    }

    @DeleteMapping("/id")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrderById(@PathVariable Long id){
        orderService.deleteById(id);
    }
}
