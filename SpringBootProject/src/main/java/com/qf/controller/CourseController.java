package com.qf.controller;

import com.qf.domain.Course;
import com.qf.service.CourseService;
import com.qf.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CourseController {
    @Resource
    private CourseService courseService;
    @RequestMapping("/findAll/{page}/{size}")
    public Response FindAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        return courseService.findAll(page, size);
    }
    @RequestMapping("/add")
    public Course add (@RequestBody Course course ){
        return  courseService.add(course);
    }

    @RequestMapping("/deleteCourse")
    public String deleteUser(@RequestBody Course course){

        return courseService.delete(course);
    }

    @RequestMapping("/update")
    public Course update(@RequestBody Course course){
        System.out.println(course);
        return  courseService.update(course);
    }


    @RequestMapping(value = "/findById/{cid}")
    public Course findById(@PathVariable Integer cid){
        return courseService.findById(cid);
    }


    //课程分类查询（小初高+推荐）
    @RequestMapping("/findShow/{info}/{type}")
    public List<Course> findCourse(@PathVariable String info, @PathVariable Integer type){
        return  courseService.findShow(info,type);
    }


    @RequestMapping("/findAllCourse/{type}")
    public List<Course> findAllCourse(@PathVariable Integer type){
        return courseService.findAllCourse(type);
    }




    //按照推荐展示课程
    @RequestMapping("/findShow/{info}")
    public List<Course> findCourse(@PathVariable String info){
        return  courseService.findShow(info);
    }




}
