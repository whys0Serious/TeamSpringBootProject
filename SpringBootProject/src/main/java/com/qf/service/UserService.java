package com.qf.service;

import com.qf.domain.User;
import com.qf.utils.BeanList;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

public interface UserService  {
    boolean registry(User user);

    boolean findByName(String name);

    String deleteuser(Integer id);

    BeanList findAlluserBypage(Pageable pageable);

    BeanList findAlluserByKey(Pageable pageable, String findBykeysearch);

    String uploaduseima(MultipartFile file);
}
