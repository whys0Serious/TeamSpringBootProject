package com.qf.controller;

import com.qf.domain.Admin;
import com.qf.domain.User;
import com.qf.service.EmailService;
import com.qf.service.UserService;
import com.qf.utils.BeanList;
import com.qf.utils.Response;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

    @RequestMapping("/selectAll1/{page}/{size}")
    public Response selectAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        return userService.selectAll(page,size);
    }
    @RequestMapping("/add1")
    public User add(@RequestBody User user){
        return  userService.add(user);
    }
    @RequestMapping("/delete1/{uid}")
    public void delete(@PathVariable("uid") Integer uid){
        userService.delete(uid);
    }
    @RequestMapping("/update1")
    public User update(@RequestBody User user){
        return  userService.update(user);
    }
    @RequestMapping("/findById1")
    public User findById(@RequestBody User user){
        return userService.findById(user.getUid());
    }

    @RequestMapping(value = "/registry1", method = RequestMethod.POST)
    public String regisrty(@RequestBody User user) {
        //验证邮箱用户是否激活
        //验证邮箱吗是否正确
        try {
            if (userService.registry(user)) {
                emailService.setStatus(user.getEmail());
                return "注册成功";
            }
        } catch (Exception e) {
            return "出现异常";
        }

        //用户验证成功注册
        try {

        } catch (Exception e) {
            return "清闲获取邮箱";
        }


        //用户验证失败注册
        return "注册失败";
    }

    /**
     * 验证用户名是否重复
     *
     * @return
     */
    @RequestMapping("/checkname")
    public String checkname(String name) {

        if (userService.findByName(name))
            return "用户名可用";
        return "用户名重复";
    }

    /**
     * 前台用户登录
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody User user) {
        return loginm(user.getUname(), user.getPass());
    }

    /**
     * 前台用户删除
     */
    @RequestMapping("/deleteuser")
    public String deleteuser(Integer id) {
        return userService.deleteuser(id);
    }

    /**
     * 注销
     */
    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "注销成功";
    }

    /**
     * 后台管理员等登陆验证
     */
    @RequestMapping("/loginAdmin")
    public String loginAdmin(String name, String pass) {
        return loginm(name, pass);
    }

    /**
     * 后台超级管理员登录验证
     */
    @RequestMapping("/loginSysAdmin")
    public String loginSysAdmin(String name,String pass){
        return loginm(name, pass);
    }

    private String loginm(String name, String pass) {
        UsernamePasswordToken token = new UsernamePasswordToken(name, pass);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            return "账户名和或者密码错误";
        } catch (NullPointerException e) {
            return "该用户没有注册";
        }
        return "登陆成功";
    }
    @RequestMapping("/findAlluserBypage")
    public BeanList findAlluserBypage(Integer page, Integer size){
        Pageable pageable=PageRequest.of(page-1,size);
        return userService.findAlluserBypage(pageable);
    }
    @RequestMapping("/findBykeysearch")
    public BeanList findAlluserBypage(String findBykeysearch,Integer page, Integer size){
        Pageable pageable=PageRequest.of(page-1,size);
        return userService.findAlluserByKey(pageable,findBykeysearch);

    }
    @RequestMapping(value = "/uploaduseima",method = RequestMethod.POST)
    public String uploaduseima(MultipartFile file){
        return userService.uploaduseima(file);
    }

    /**
     * 修改密码
     */
    @RequestMapping("/updatepwd")
    public String updatepwd(String name,String pass){
        return userService.updatepwd(name,pass);
    }
    @RequestMapping(value = "/rememberme")
    public String rememberme(String name,String pass, HttpServletResponse response, HttpServletRequest httpServletRequest){
        System.out.println(name);
        Cookie cookie=new Cookie(name,pass);
        for (Cookie cookie1 : httpServletRequest.getCookies()) {
            if(cookie1.getName().equals(name)){
                cookie1.setValue(pass);
                return "";
            }
        }
        cookie.setMaxAge(60*60*24*30);
        response.addCookie(cookie);
        return "nu";
    }
    @RequestMapping("/gtepasswod")
    public String gtepasswod(String name, HttpServletRequest httpServletRequest){
        for (Cookie cookie : httpServletRequest.getCookies()) {
            if(cookie.getName().equals(name))
                return cookie.getValue();
        }
        return  "";
    }
    @RequestMapping("/getuseradnima")
    public User user(){

        Subject subject = SecurityUtils.getSubject();
        String principal = (String) subject.getPrincipal();
        User user = userService.finduser(principal);
        return user;
    }
    @RequestMapping("/findalldmin")
    public List<Admin> findalldmin(){
        return userService.findalldmin();
    }
    @RequestMapping(value = "/addadmin",method = RequestMethod.POST)
    public boolean addadmin(@ModelAttribute Admin admin){
        return userService.addadmin(admin);
    }
    @RequestMapping(value = "/logininterrept")
    public String logininterrept(){
        return "";
    }


}
