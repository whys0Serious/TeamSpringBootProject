package com.qf.dao;

import com.qf.domain.EmailCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailCode,Integer> {
    public EmailCode findByMailname(String mail);
}
