package com.qf.service.impl;

import com.qf.dao.UserRepository;
import com.qf.domain.User;
import com.qf.service.UserService;
import com.qf.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean findByName(String name) {
        return userRepository.findByUname(name) == null ? true : false;
    }

    @Override
    public String deleteuser(Integer id) {
        userRepository.deleteById(id);
        return "删除成功";
    }

    @Override
    public Response selectAll(Integer page, Integer size) {
        Pageable pages = PageRequest.of(page - 1, size);
        Page<User> all = userRepository.findAll(pages);
        Response response = new Response();
        response.setList(all.getContent());
        response.setTotal(all.getTotalElements());
        return response;
    }
    @Override
    public Integer delete(Integer uid) {
        return null;
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User findById(Integer uid) {
        return userRepository.findById(uid).get();
    }

    @Override
    public boolean registry(User user) {

        User save = userRepository.save(user);
        /**
         * 当用户添加成功时返回true
         */
        return save==null?false:true;
    }
}
