package com.qf.service.impl;

import com.qf.dao.EmailRepository;
import com.qf.domain.EmailCode;
import com.qf.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private EmailRepository emailRepository;

    @Override
    public String checkemailcode(String mail, String code) {
        EmailCode byMailnameAndCode = emailRepository.findByMailnameAndCode(mail, code);
        return byMailnameAndCode==null?"验证码错误":"验证码正确";
    }

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
    public String isStatus(String email) {
        EmailCode emailCode = emailRepository.findByMailname(email);
        if(emailCode!=null)
            return emailCode.getStatus()!=1?"邮箱可用":"邮箱已经被注册";
        return "现货区验证码";
    }

    @Override
    public String deleteemail(Integer id) {
        emailRepository.deleteById(id);
        return "删除成功";
    }
    @Override
    public boolean save(String mailname,String code) {
        int i = emailRepository.deleteByMailname(mailname);
        EmailCode emailCode=new EmailCode();
        emailCode.setMailname(mailname);
        emailCode.setCode(code);
        //邮箱验证码添加成功时
        return emailRepository.save(emailCode)==null?false:true;
    }
}
