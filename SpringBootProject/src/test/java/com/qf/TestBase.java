package com.qf;

import com.qf.dao.TestRepository;
import com.qf.utils.UploadUtils;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.nio.file.Files;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RunSpringApplication.class)
public class TestBase {

    @Autowired
    private TestRepository testRepository;
    @Test
    public void test(){
        System.out.println(testRepository.findAll());
 }

 @Autowired
   private UploadUtils uploadUtils;

 @Test
    public void testUpload(){
     String path=("D:\\classnote\\Html\\bgood1.png");
     File f = new File(path);
     try {
         InputStream inputStream = new FileInputStream(f);
         MultipartFile multipartFile = new MockMultipartFile(f.getName(), inputStream);
         uploadUtils.upload(multipartFile);
         System.out.println("success");
     }catch (Exception ex){
         ex.printStackTrace();
     }



 }
}