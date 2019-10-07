package com.qf.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

@Component
public class MailUtils {
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String sendusername;
    public  String getCode(String mailname){
        String randomcode = randomcode();
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setTo(mailname);
        simpleMailMessage.setFrom(sendusername);
        simpleMailMessage.setSubject("邮箱验证码");
        simpleMailMessage.setText("亲爱的用户,你的验证码为:"+randomcode+",请你妥善把保管(001Team)");
        //将验证码发送到对方邮箱中
//        javaMailSender.send(simpleMailMessage);
        return randomcode;
    }
    private  String randomcode(){
        /**
         * 字母数字随机数池
         */
        String ucode="abcdefghijklmnopqrstuvwxyz";
//        String lcode=ucode.toUpperCase();
        String ncode="123457890";
        String code=ucode+ncode;
        //随机生成6位数随机池中的字符
        StringBuffer str=new StringBuffer();
        Random random=new Random();
        for (int i = 0; i < 6; i++) {
            int lenth=code.length();
            int rindex=random.nextInt(lenth);
            str.append(code.substring(rindex,rindex+1));
        }
        //用数组工具类返回数组字符串
        return str.toString();
    }
}
