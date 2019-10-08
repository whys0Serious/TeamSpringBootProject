package com.qf.controller;

import com.qf.domain.EmailCode;
import com.qf.service.EmailService;
import com.qf.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;
    /**
     * 邮箱验证码==得首先请求验证码,然后提交注册
     *
     * 1.邮箱账号
     * 2.需要字段:邮箱账号
     * @return
     */
    @Autowired
    private MailUtils mailUtils;
    @RequestMapping("/getemailcode")
    public String emailcode(String email){
        //获取邮箱验证码
        String code="";
        try {
           code= mailUtils.getCode(email);
        }catch (Exception e){
            e.printStackTrace();
            return "获取验证码出现异常";
        }
        //存储到数据库
        try {
            if(emailService.save(email,code))
                return code;
        }catch (Exception e){
            e.printStackTrace();
            return "保存出现异常";
        }

        return"邮箱验证码获取失败";
    }
    /**
     * 邮箱账号删除
     */
    @RequestMapping("/deleteemail")
    public String deleteemail(Integer id){
        return emailService.deleteemail(id);
    }

    /**
     * 邮箱验证码验证
     * @param mail,code
     * @return
     */
    @RequestMapping("/checkemailcode")
    public String checkemailcode(String mail,String code){
        return emailService.checkemailcode(mail,code);
    }
    @RequestMapping("/checkmail")
    public String checkmail(String mail){
        return emailService.isStatus(mail);
    }
    /**
     * 验证码获取
     */
    @RequestMapping("/getcodepwd")
    public String getcodepwd(){
        return mailUtils.randomcode();
    }
}
