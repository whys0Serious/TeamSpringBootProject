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
        simpleMailMessage.setText("亲爱用户,你的验证码为:"+randomcode+"请你妥善把保管(001Team)");
        return randomcode;
    }
    private  String randomcode(){
        /**
         * 字母数字随机数池
         */
        String ucode="abcdefghijklmnopqrstuvwxyz";
        String lcode=ucode.toUpperCase();
        String ncode="123457890";
        String code=ucode+lcode+ncode;
        //随机生成6位数随机池中的字符
        char c[]=new char[6];
        Random random=new Random();
        for (int i = 0; i < 6; i++) {
            int lenth=code.length()-1;
            int rindex=random.nextInt(lenth);
            c[i] = code.charAt(rindex);
        }
        //用数组工具类返回数组字符串
        return Arrays.toString(c);
    }
}