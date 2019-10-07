package com.qf.service;

import com.qf.domain.Course;
import com.qf.utils.Response;

public interface CourseService {
   //查询全部
   Response findAll(Integer page, Integer size);
    //删除
    Integer delete(Integer cid);
    //增加
    Course add(Course course);
    //修改
    Course update(Course course);
    //根据id查询
    Course findById(Integer cid);
}
