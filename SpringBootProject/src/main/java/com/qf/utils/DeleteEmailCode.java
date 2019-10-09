package com.qf.utils;

import com.qf.dao.EmailRepository;
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
    @Scheduled(cron="0 */1 * * * ?")
    public void task(){
        System.out.println(new Date()+":共删除了"+repository.deleteByStatus((byte)0)+"条垃圾验证码");
    }
}
