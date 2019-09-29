package com.qf;

import com.qf.dao.TestRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RunSpringApplication.class)
public class TestBase {

    @Autowired
    private TestRepository testRepository;
    @Test
    public void test(){
        System.out.println(testRepository.findAll());
 }
}
