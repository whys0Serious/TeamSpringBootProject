package com.qf.dao;

import com.qf.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer> ,JpaSpecificationExecutor<User> {
    public User findByUname(String name);

    @Query(value="SELECT * FROM user where uname like #{name}  }",nativeQuery=true)
    User findAlluserByKey(String name,String email,String sex);
}
