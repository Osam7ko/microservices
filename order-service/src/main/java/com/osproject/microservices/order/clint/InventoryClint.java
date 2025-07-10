package com.osproject.microservices.order.clint;

import groovy.util.logging.Slf4j;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

@Slf4j
public interface InventoryClint {

    Logger log = LoggerFactory.getLogger(InventoryClint.class);

    @GetExchange("/api/inventory")
    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
    @Retry(name = "inventory")
    boolean isInStock(@RequestParam("skuCode") String skuCode,
                      @RequestParam("quantity") Integer quantity);


    default boolean fallbackMethod(String skuCode,Integer quantity,Throwable throwable){
        log.info("Cannot get inventory for skuCode {}, failure reason: {}",skuCode,throwable.getMessage());
        return false;
    }

}
