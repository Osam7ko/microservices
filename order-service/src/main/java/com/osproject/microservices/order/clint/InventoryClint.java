package com.osproject.microservices.order.clint;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

public interface InventoryClint {

    @GetExchange("/api/inventory")
    boolean isInStock(@RequestParam String skuCode,@RequestParam Integer quantity);
}
