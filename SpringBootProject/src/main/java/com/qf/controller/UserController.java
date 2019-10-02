package com.qf.controller;

import com.qf.domain.EmailCode;
import com.qf.domain.User;
import com.qf.service.EmailService;
import com.qf.service.UserService;
import com.qf.utils.MailUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *用户给管理模块
 *接收json串,返回json串
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private EmailService emailService;
    @RequestMapping(value = "/registry",method = RequestMethod.POST)
    public String regisrty(@RequestBody User user){
        //验证邮箱用户是否激活
        //验证邮箱吗是否正确
        try {
            if(userService.registry(user)){
                emailService.setStatus(user.getEmail());
                return "注册成功";
            }
        }catch (Exception e){
            return "出现异常";
        }


        //用户验证成功注册
        try {

        }catch (Exception e){
            return "清闲获取邮箱";
        }


        //用户验证失败注册
        return "注册失败";
    }

    /**
     *验证用户名是否重复
     * @return
     */
    @RequestMapping("/checkname")
    public String checkname(String name){

        if(userService.findByName(name))
            return "用户名可用";
        return "用户名重复";
    }
    /**
     * 前台用户登录
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestBody User user){
        return loginm(user.getUname(),user.getPass());
    }
    /**
     * 前台用户删除
     */
    @RequestMapping("/deleteuser")
    public String deleteuser(Integer id){
        return userService.deleteuser(id);
    }
    /**
     * 注销
     */
    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "注销成功";
    }
    /**
     * 后台管理员等登陆验证
     */
    @RequestMapping("/loginAdmin")
    public String loginAdmin(String name,String pass){
        return loginm(name, pass);
    }
    /**
     * 后台超级管理员等公路验证
     */
    @RequestMapping("/loginSysAdmin")
    public String loginSysAdmin(String name,String pass){
        return loginm(name, pass);
    }

    private String loginm(String name, String pass) {
        UsernamePasswordToken token=new UsernamePasswordToken(name,pass);
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(token);
        }catch (AuthenticationException e){
            return "账户名和或者密码错误";
        }catch (NullPointerException e){
            return "该用户没有注册";
        }
        return "登陆成功";
    }


}
