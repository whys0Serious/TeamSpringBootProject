package com.qf.controller;

import com.qf.domain.Teacher;
import com.qf.service.TeacherService;
import com.qf.utils.BeanList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/findTeacherById",method = RequestMethod.POST)
    public Teacher findById(@RequestBody Teacher teacher){
            return teacherService.findByThid(teacher.getThid());
    }
    //查询是所有教师
    @RequestMapping("/finallteacher")
    public BeanList finallteacher(Integer page, Integer size){
        Pageable pageable=PageRequest.of(page-1,size);
        return teacherService.finallteacher(pageable);
    }
    //查询是所有教师
    @RequestMapping("/upthima")
    public String upthima(Integer id,String img){
        return teacherService.upthima(id,img);
    }




    //删除一个教师  deleteteacher  addtecaher
    @RequestMapping("/deleteteacher")
    public String deleteteacher(@RequestBody Teacher teacher){

        return teacherService.deleteteacher(teacher);
    }


    //添加一个教师  addtecaher
    @RequestMapping("/addtecaher")
    public Teacher addtecaher(@RequestBody Teacher teacher){

        return teacherService.addtecaher(teacher);
    }


    //查询一个教师  findTcherById
    @RequestMapping("/findTcherById/{thid}")
    public Teacher findTcherById(@PathVariable Integer thid){

        return teacherService.findTcherById(thid);
    }



    //修改一个教室
    @RequestMapping("/updatecaher")
    public Teacher updatecaher(@RequestBody Teacher teacher){
        return  teacherService.updatecaher(teacher);
    }
}
