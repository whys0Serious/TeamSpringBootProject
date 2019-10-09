package com.qf.controller;

import com.alipay.api.AlipayApiException;
import com.qf.domain.Course;
import com.qf.utils.AlipayUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AlipayController {
        @Autowired
        private AlipayUtil alipayUtil;

    @RequestMapping(value = "/alipay",method = RequestMethod.POST)
    public String pay(@RequestBody Course course){
        String pay="";
        try {
            pay = alipayUtil.pay(course.getPrice(),course.getCname());
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        System.out.println(pay);
        return pay;
    }
}
