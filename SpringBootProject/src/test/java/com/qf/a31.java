package com.qf;

import com.qf.dao.EmailRepository;
import com.qf.utils.MailUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class a31 {
    @Test
    public void test1(){

        int i=1;
        i=i++;
        int j=i++;

        int k=i+ ++i*i++;

        System.out.println("i="+i);
        System.out.println("j="+j);
        System.out.println("k="+k);
    }
@Test
public void test2(){
    Map map=new HashMap();

    map.put("小学",18);
    map.put("初中",30);
    map.put("高中",5);
    System.out.println(map);
}

}
