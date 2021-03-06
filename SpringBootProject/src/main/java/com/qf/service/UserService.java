package com.qf.service;

import com.qf.domain.Admin;
import com.qf.domain.User;
import com.qf.utils.BeanList;
import com.qf.utils.Response;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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

    BeanList findAlluserBypage(Pageable pageable);

    BeanList findAlluserByKey(Pageable pageable, String findBykeysearch);

    String uploaduseima(MultipartFile file);

    String updatepwd(String name, String email);

    /**
     * 再次根据name查对象
     */
    User finduser(String name);

    List<Admin> findalldmin();

    boolean addadmin(Admin admin);

    String updateusery(User user);


    String upima(Integer id, String ima);

    String findbysatus(Integer uid);
}
