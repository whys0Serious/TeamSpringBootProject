package com.qf.service.impl;

import com.qf.dao.TeacherRepository;
import com.qf.domain.Teacher;
import com.qf.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class  TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public Teacher findByThid(Integer thid) {
        return teacherRepository.findByThid(thid);
    }
}
