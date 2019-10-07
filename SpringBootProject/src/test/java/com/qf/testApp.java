package com.qf;

import com.qf.dao.EmailRepository;
import com.qf.utils.MailUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = RunSpringApplication.class)
@RunWith(SpringRunner.class)
public class testApp {
    @Autowired
    private EmailRepository emailRepository;
    @Autowired
    private MailUtils mailUtils;
    @Test
    public void test(){
        emailRepository.deleteByMailname("1358616552");
        System.out.println();
    }

}
