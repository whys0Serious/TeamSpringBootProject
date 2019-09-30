package com.qf.service.impl;

import com.qf.dao.UserRepository;
import com.qf.domain.User;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean findByName(String name) {
        return userRepository.findByUname(name)==null?true:false;
    }

    @Override
    public String deleteuser(Integer id) {
        userRepository.deleteById(id);
        return "删除成功";
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
