package com.qf.dao;

import com.qf.domain.Course;
import org.omg.CORBA.INTERNAL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface CourseRepository extends JpaRepository<Course,Integer> {

    List<Course> findByInfoAndCtid(String info, Integer ctid);

    List<Course> findAllByCtid(Integer ctid);

    //热门推荐
    List<Course> findByInfo(String info);

    //查询课程详情
    Course findByCid(Integer cid);
    /**
     * 根据课程编号查老师
     */
    List<Course> findByCnameLike(String cname);
    Course findByCname(String cname);

    //模糊查询
    List<Course> findByCtidAndCnameLike(Integer ctid,String cname);

    List<Course> findByCtid(Integer ctid);



}
