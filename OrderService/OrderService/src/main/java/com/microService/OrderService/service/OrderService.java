package com.microService.OrderService.service;

import com.microService.OrderService.DTO.OrderRequest;

public interface OrderService {
    long placeOrder(OrderRequest orderRequest);
}
