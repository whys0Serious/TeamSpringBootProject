package com.qf.service.impl;

import com.qf.dao.UserRepository;
import com.qf.domain.User;
import com.qf.service.UserService;
import com.qf.utils.BeanList;
import com.qf.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {



    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UploadUtils uploadUtils;
    @Override
    public String uploaduseima(MultipartFile file) {
        return uploadUtils.upload(file);
    }
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
    public BeanList findAlluserBypage(Pageable pageable) {
        Page<User> all = userRepository.findAll(pageable);
        BeanList beanList=new BeanList();
        beanList.setList(all.getContent());
        beanList.setTotal(all.getTotalElements());
        return beanList;
    }

    @Override
    public BeanList findAlluserByKey(Pageable pageable, String findBykeysearch) {
        BeanList beanList = new BeanList();
        try {
            Page<User> all = userRepository.findAll(pageable);
            beanList.setList(all.getContent());
            beanList.setTotal(all.getTotalElements());
        }catch (Exception e){
            beanList.setMess(e.getLocalizedMessage());
        }
        return beanList;
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
