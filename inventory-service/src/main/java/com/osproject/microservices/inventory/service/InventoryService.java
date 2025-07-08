package com.osproject.microservices.inventory.service;

import com.osproject.microservices.inventory.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public boolean isInStack(String skuCode,Integer quantity){
        // find an inventory for a given sku code where quantity >= 0
        return inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode,quantity);
    }
}
