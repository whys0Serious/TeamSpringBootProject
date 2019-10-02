package com.qf.dao;

import com.qf.domain.EmailCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailCode,Integer> {
    public EmailCode findByMailname(String mailname);
    public EmailCode findByMailnameAndCode(String mailname,String code);
    public int deleteByStatus(byte status);
    public int deleteByMailname(String mailname);
}
