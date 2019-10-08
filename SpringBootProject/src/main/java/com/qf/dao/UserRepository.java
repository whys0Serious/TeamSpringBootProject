package com.qf.dao;

import com.qf.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer> ,JpaSpecificationExecutor<User> {
    public User findByUname(String name);

    @Query(value="SELECT * FROM user where uname like #{name}  }",nativeQuery=true)
    User findAlluserByKey(String name,String email,String sex);


//    @Update(value = "update user set pass=#{pwd} where name=#{name}")
//    int updatePwd(String name,String pwd);
}
