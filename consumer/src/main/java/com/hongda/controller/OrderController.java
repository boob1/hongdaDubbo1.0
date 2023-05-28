package com.hongda.controller;

import com.hongda.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName OrderController
 * @Description TODO
 * @Author liuyibo
 * @Date 2023/5/27 11:51
 **/
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/order")
    public String getOrderName() {
        return orderService.getOrder();
    }
}
