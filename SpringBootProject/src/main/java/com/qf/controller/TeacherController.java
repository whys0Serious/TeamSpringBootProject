package com.qf.controller;

import com.qf.domain.Teacher;
import com.qf.service.TeacherService;
import com.qf.utils.BeanList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
