package com.qf.service;

import com.qf.domain.Course;
import com.qf.utils.Response;

import java.util.List;

public interface CourseService {
   //查询全部
   Response findAll(Integer page, Integer size);
   //删除
   String delete(Course course);
    //增加
    Course add(Course course);
    //修改
    Course update(Course course);
    //根据id查询一个
    Course findById(Integer cid);

    //按课程分类展示课程（小初高+推荐）
    List<Course> findShow(String info, Integer ct_id);


    //按推荐展示课程（暂时是当info等于100时）
    List<Course> findShow(String info);

    //按课程分类查询所有
    List<Course> findAllCourse(Integer ctid);

    //根据编号查询课程详情
    Course findCourseInfo(Integer cid);
    //根据课程名字模糊查询
    List<Course> findbyclike(String str);

    Course findbycname(String cname);

    String upima(Integer cid, String ima);

    //模糊查询课程
   List<Course> findCourseByName(Integer ctid,String name);
   //降序
//    List<Course> course();
    //新增
    Course insertCourseNum(Course course);
}
