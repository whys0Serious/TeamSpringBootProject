package com.qf.controller;

import com.qf.dao.OrderRepository;
import com.qf.domain.Order;
import com.qf.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @RequestMapping(value = "/findOrderByUid",method = RequestMethod.POST)
    public List<Order> findOrderByuid(@RequestBody User user){
        List<Order> orders = orderRepository.findAllByUid(user.getUid());
            return orders;
    }
}
