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


    //课程分类查询（小初高+推荐）
    @RequestMapping("/findShow/{info}/{type}")
    public List<Course> findCourse(@PathVariable String info, @PathVariable Integer type){
        return  courseService.findShow(info,type);
    }
    @RequestMapping("/findAllCourse/{type}")
    public List<Course> findAllCourse(@PathVariable Integer type){
        return courseService.findAllCourse(type);
    }
}
