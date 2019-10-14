package com.qf.utils;

import com.qf.dao.EmailRepository;
import com.qf.dao.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Date;

@Component
@Transactional
public class DeleteEmailCode {
    @Autowired
    private EmailRepository repository;
    @Autowired
    private OrderRepository orderRepository;
    @Scheduled(cron="0 */1 * * * ?")
    public void task(){
        System.out.println(new Date()+":共删除了"+repository.deleteByStatus((byte)0)+"条垃圾验证码");
    }

    @Scheduled(cron="0 */10 * * * ?")
    public void deleteOrderNotPay(){
        System.out.println(new Date()+":已删除"+orderRepository.deleteByTradstatus("待支付")+"条未支付订单");
    }
}
