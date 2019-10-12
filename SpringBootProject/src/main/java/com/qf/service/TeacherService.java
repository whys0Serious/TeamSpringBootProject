package com.qf.service;

import com.qf.domain.Teacher;
import com.qf.utils.BeanList;
import org.springframework.data.domain.Pageable;

public interface TeacherService {

    Teacher findByThid(Integer thid);

    BeanList finallteacher(Pageable pageable);

    String upthima(Integer id, String img);

    String deleteteacher(Teacher teacher);

    Teacher addtecaher(Teacher teacher);

    Teacher findTcherById(Integer thid);

    Teacher updatecaher(Teacher teacher);
}
