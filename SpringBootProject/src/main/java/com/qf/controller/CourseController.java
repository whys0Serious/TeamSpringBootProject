package com.qf.controller;

import com.qf.domain.Course;
import com.qf.service.CourseService;
import com.qf.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    @RequestMapping("/delete/{cid}")
    public void delete(@PathVariable("cid") Integer cid){
         courseService.delete(cid);
    }
    @RequestMapping("/update")
    public Course update(@RequestBody Course course){
        return  courseService.update(course);
    }
    @RequestMapping("/findById")
    public Course findById(@RequestBody Course course){
        return courseService.findById(course.getCid());
    }
}
