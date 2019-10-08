package com.qf.controller;

import com.qf.domain.Teacher;
import com.qf.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
