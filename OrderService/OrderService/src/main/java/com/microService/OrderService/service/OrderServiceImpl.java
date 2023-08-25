package com.microService.OrderService.service;

import com.microService.OrderService.DTO.OrderRequest;
import com.microService.OrderService.entity.Order;
import com.microService.OrderService.repository.OrderRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public long placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        BeanUtils.copyProperties(orderRequest, order);
        Order orderDetails = orderRepository.save(order);
        return orderDetails.getId();
    }
}
