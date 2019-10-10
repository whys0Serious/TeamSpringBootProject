package com.qf.service;

import com.qf.domain.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher findByThid(Integer thid);

    List<Teacher> finallteacher();

    String upthima(Integer id, String img);
}
