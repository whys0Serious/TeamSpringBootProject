package com.qf.service;

import com.qf.domain.Course;
import com.qf.utils.Response;

import java.util.List;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 张小米
 * \* Date: 2019/10/11
 * \* Time: 9:40
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public interface DataSerchService {

    List<Course> findAll( );

    Map findNum();
}