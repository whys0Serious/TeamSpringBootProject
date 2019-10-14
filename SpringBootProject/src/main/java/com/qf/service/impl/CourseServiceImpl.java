package com.qf.service.impl;

import com.qf.dao.CourseRepository;
import com.qf.domain.Course;
import com.qf.service.CourseService;
import com.qf.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepository courseRepository;
    @Override
    public Response findAll(Integer page, Integer size) {
        Pageable pages=PageRequest.of(page-1,size);
        Page<Course> all=courseRepository.findAll(pages);
        Response response=new Response();
        response.setList(all.getContent());
        response.setTotal(all.getTotalElements());
        return response;
    }


    @Override
    public String delete(Course course) {
        courseRepository.deleteById(course.getCid());

        return "删除成功";
    }

    @Override
    public Course add(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course update(Course course) {
        return courseRepository.saveAndFlush(course);
    }

    @Override
    public String upima(Integer cid, String ima) {
        Optional<Course> byId = courseRepository.findById(cid);
        Course course = byId.get();
        course.setMainpic(ima);
        return courseRepository.save(course).toString();
    }

    @Override
    public Course findbycname(String cname) {
        return courseRepository.findByCname(cname);
    }

    @Override
    public List<Course> findbyclike(String str) {
        return courseRepository.findByCnameLike("%"+str+"%");
    }

    @Override
    public Course findById(Integer cid) {
        Optional<Course> byId = courseRepository.findById(cid);

        if (byId.isPresent()){
            Course course = byId.get();
            return course;
        }
        return null;
    }


    @Override
    public List<Course> findShow(String info, Integer ctid) {
        return courseRepository.findByInfoAndCtid(info,ctid);
    }

    @Override
    public List<Course> findAllCourse(Integer ctid) {
        return courseRepository.findAllByCtid(ctid);
    }


    //热门推荐
    @Override
    public List<Course> findShow(String info) {
        return courseRepository.findByInfo(info);
    }

    @Override
    public Course findCourseInfo(Integer cid) {
        return courseRepository.findByCid(cid);
    }

    @Override
    public List<Course> findCourseByName(Integer ctid,String name) {

        return courseRepository.findByCtidAndCnameLike(ctid,"%"+name+"%");
    }

    @Override
    public Course insertCourseNum(Course course) {
        Course course1 = courseRepository.saveAndFlush(course);
        return course1;
    }

    /*@Override
    public List<Course> course() {
        return courseRepository.finddesc();
    }*/
}
