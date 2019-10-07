package com.qf.service;

import com.qf.domain.User;

public interface UserService  {
    boolean registry(User user);

    boolean findByName(String name);

    String deleteuser(Integer id);


}
