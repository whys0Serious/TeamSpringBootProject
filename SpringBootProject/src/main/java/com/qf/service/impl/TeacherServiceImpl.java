package com.qf.service.impl;

import com.qf.dao.TeacherRepository;
import com.qf.domain.Teacher;
import com.qf.service.TeacherService;
import com.qf.utils.BeanList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class  TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher findByThid(Integer thid) {
        return teacherRepository.findByThid(thid);
    }

    @Override
    public String upthima(Integer id, String img) {
        Teacher thid = teacherRepository.findByThid(id);
        thid.setThpic(img);
        return teacherRepository.save(thid).toString();
    }

    @Override
    public BeanList finallteacher(Pageable pageable) {
        Page<Teacher> teachers = teacherRepository.findAll(pageable);
        long elements = teachers.getTotalElements();
        List<Teacher> content = teachers.getContent();
        BeanList beanList=new BeanList(content,elements);
        return beanList;
    }
}
