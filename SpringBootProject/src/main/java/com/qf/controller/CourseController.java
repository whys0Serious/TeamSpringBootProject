package com.qf.controller;

import com.qf.domain.Course;
import com.qf.domain.Teacher;
import com.qf.service.CourseService;
import com.qf.service.TeacherService;
import com.qf.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CourseController {
    @Resource
    private CourseService courseService;
    @Autowired
    private TeacherService teacherService;
    @RequestMapping("/findAll/{page}/{size}")
    public Response FindAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
        return courseService.findAll(page, size);
    }
    @RequestMapping("/add")
    public Course add (@RequestBody Course course ){
        Teacher teacher=new Teacher();
        teacher.setThname(course.getThname());
        Teacher teacher1 = teacherService.addtecaher(teacher);
        course.setThid(teacher1.getThid());
        return  courseService.add(course);
    }

    @RequestMapping("/deleteCourse")
    public String deleteUser(@RequestBody Course course){

        return courseService.delete(course);
    }

    @RequestMapping("/update")
    public Course update(@RequestBody Course course){
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


    //根据课程名称分类
    @RequestMapping(value = "/findCourseByName",method = RequestMethod.POST)
    public List<Course> findCourseByName(@RequestBody Course course){
            return courseService.findCourseByName(course.getCtid(),course.getCname());
    }

    //根据课程编号查询课程详情
    @RequestMapping(value = "/findCourseInfo",method = RequestMethod.POST)
    public Course findCourseInfo(@RequestBody Course course){
        return courseService.findCourseInfo(course.getCid());
    }
    //根据课名模糊查询
    @RequestMapping("/findbyclike")
    public List<Course> findbyclike(String like){
        return courseService.findbyclike(like);
    }
    //根据课程名关键字查询对象
    @RequestMapping("/findbycname")
    public Course findbycname(String cname){
        return courseService.findbycname(cname);
    }

    //修改课程图片
    @RequestMapping("/upima")
    public String upima(Integer id,String ima){
        return courseService.upima(id,ima);
    }


}
