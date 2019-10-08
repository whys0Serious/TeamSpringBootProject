package com.qf.service;

import com.qf.domain.User;
import com.qf.utils.Response;

public interface UserService  {
    boolean registry(User user);

    boolean findByName(String name);

    String deleteuser(Integer id);
    //查询全部
    Response selectAll(Integer page, Integer size);
    //删除
    Integer delete(Integer uid);
    //增加
    User add(User user);
    //修改
    User update(User user);
    //根据id查询
    User findById(Integer uid);

}
