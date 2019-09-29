package com.qf.dao;

import com.qf.domain.Test;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;


import java.util.List;

@Mapper
@Component("test")
public interface TestMapper {

    List<Test> findAll();

}
