package com.qf.controller;

import com.alipay.api.AlipayApiException;
import com.qf.config.AlipayConfig;
import com.qf.config.AlipayNotifyParam;
import com.qf.dao.OrderRepository;
import com.qf.domain.Course;
import com.qf.domain.Order;
import com.qf.domain.User;
import com.qf.service.UserService;
import com.qf.utils.AlipayUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@RestController
public class AlipayController {
        @Autowired
        private AlipayUtil alipayUtil;

        @Autowired
        private OrderRepository orderRepository;
        @Autowired
        private UserService userService;

    @RequestMapping(value = "/alipay",method = RequestMethod.POST)
    public String pay(@RequestBody Course course){
        String pay="";
        try {
            pay = alipayUtil.pay(course.getPrice(),course.getCname());
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        System.out.println(pay);
        //生成订单信息
        Order order=new Order();
        Subject subject = SecurityUtils.getSubject();
        String principal = (String) subject.getPrincipal();
        User user = userService.finduser(principal);//获得用户信息
        //获取订单号
        String tradeno = alipayUtil.trade_no;
        order.setUid(user.getUid());
            order.setTradacount(course.getPrice());
            order.setTradcname(course.getCname());
            order.setTradstatus("待支付");
            order.setTradnum(tradeno);
            order.setTradtime(new Date());
        System.out.println(order.toString());
        //存入数据库
        Order save = orderRepository.save(order);
        if(save!=null){
            System.out.println("生成一条订单信息！");
        }
        return pay;
    }

    //异步返回结果
    @RequestMapping(value = "/alipay_callback",method = RequestMethod.POST)
   public List<Order> alipayCallback(@RequestBody AlipayNotifyParam alipayNotifyParam){
                String tradnum=alipayNotifyParam.getOut_trade_no();
                Order order = orderRepository.findByTradnum(tradnum);
                if(order!=null){
                    order.setTradstatus("支付完成");
                }
                orderRepository.saveAndFlush(order);
                List<Order> list = orderRepository.findAllByUid(order.getUid());
                return list;
    }

    @RequestMapping(value = "/payback",method = RequestMethod.POST)
    public String payback(@RequestBody Order order){
        String pay="";
        alipayUtil.setTrade_no(order.getTradnum());
        try {
            pay = alipayUtil.pay(order.getTradacount(),order.getTradcname());
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        System.out.println(pay);
        //更改订单状态
        return pay;
    }
}
