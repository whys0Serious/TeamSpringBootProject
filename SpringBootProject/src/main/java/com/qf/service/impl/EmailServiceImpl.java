package com.qf.service.impl;

import com.qf.dao.EmailRepository;
import com.qf.domain.EmailCode;
import com.qf.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private EmailRepository emailRepository;

    @Override
    public boolean isCode(String email) {
        return emailRepository.findByMailname(email)==null?false:true;
    }

    @Override
    public void setStatus(String email) {
        EmailCode repository = emailRepository.findByMailname(email);
        repository.setStatus((byte)1);
        emailRepository.save(repository);
    }

    @Override
    public boolean isStatus(String email) {
        return emailRepository.findByMailname(email).getStatus()==1?false:true;
    }

    @Override
    public String deleteemail(Integer id) {
        emailRepository.deleteById(id);
        return "删除成功";
    }
    @Override
    public boolean save(String mailname,String code) {
        EmailCode emailCode=new EmailCode();
        emailCode.setMailname(mailname);
        emailCode.setCode(code);
        //邮箱验证码添加成功时
        return emailRepository.save(emailCode)==null?false:true;
    }
}
