package com.qf.service.impl;

import com.qf.dao.CourseRepository;
import com.qf.domain.Course;
import com.qf.service.DataSerchService;
import com.qf.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 张小米
 * \* Date: 2019/10/11
 * \* Time: 9:41
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Service
public class DataSerchServiceImp implements DataSerchService {
    @Autowired
    CourseRepository courseRepository;

    public List<Course> findAll () {
        return courseRepository.findAll(new Sort(Sort.Direction.DESC,"details")).subList(0,5);
    }

    @Override
    public Map findNum() {

        Map<String,Integer> map=new HashMap();
        //小学
        Integer size = courseRepository.findAllByCtid(1).size();
        map.put("小学",size);
        //初中
        Integer size1 = courseRepository.findAllByCtid(2).size();
        map.put("初中",size1);
        //高中
        Integer size2 = courseRepository.findAllByCtid(3).size();
        map.put("高中",size2);

        return map;
    }

}