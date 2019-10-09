package com.qf.service.impl;

import com.qf.dao.EmailRepository;
import com.qf.dao.UserRepository;
import com.qf.domain.User;
import com.qf.service.UserService;
import com.qf.utils.BeanList;
import com.qf.utils.Response;
import com.qf.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

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
    public String updatepwd(String name, String pwd) {
//        return userRepository.updatePwd(name,pwd)==1?"修改成功":"修改失败";
        return null;
    }

    @Override
    public User finduser(String name) {
        return userRepository.findByUname(name);
    }

    @Override
    public boolean findByName(String name) {
        return userRepository.findByUname(name) == null ? true : false;
    }
    @Autowired
    private EmailRepository emailRepository;
    @Override
    public String deleteuser(Integer id) {
        userRepository.deleteById(id);
        Optional<User> byId = userRepository.findById(id);
        User user = byId.get();
        emailRepository.deleteByMailname(user.getEmail());
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
