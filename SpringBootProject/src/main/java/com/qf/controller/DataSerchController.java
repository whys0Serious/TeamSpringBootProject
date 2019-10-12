package com.qf.controller;

import com.qf.service.CourseService;
import com.qf.service.DataSerchService;
import com.qf.domain.Course;
import com.qf.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 张小米
 * \* Date: 2019/10/11
 * \* Time: 9:39
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 */
@RestController
public class DataSerchController {

    @Resource
    private DataSerchService dataSerchService;


    @RequestMapping("/findAlldata")
    public List<Course> FindAll() {
        return dataSerchService.findAll();
    }

    //根据年级汇总课程总书
    @RequestMapping("/findA")
    public Map FindNum() {
        return dataSerchService.findNum();
    }


}