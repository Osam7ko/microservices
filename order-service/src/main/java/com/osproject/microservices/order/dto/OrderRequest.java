package com.osproject.microservices.order.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public record OrderRequest(Long id, String orderNumber, String skuCode,BigDecimal price,Integer quantity,UserDetails userDetails) {

    public record UserDetails(String email, String firstName, String lastName){}
}

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class OrderRequest {
//    private List<OrderLineItemsDto> orderLineItemsDtoList;
//}