package com.microService.OrderService.controller;

import com.microService.OrderService.DTO.OrderRequest;
import com.microService.OrderService.service.OrderService;
import com.netflix.discovery.converters.Auto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // place order
    @PostMapping("/placeOrder")
    public ResponseEntity<Long> placeOrder(@RequestBody OrderRequest orderRequest) {
         long orderId = orderService.placeOrder(orderRequest);
         log.info("order id {} ",orderId);
         return new ResponseEntity<>(orderId, HttpStatus.OK);
    }
}
