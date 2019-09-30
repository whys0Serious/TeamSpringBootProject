package com.qf.service;

import com.qf.domain.EmailCode;

public interface EmailService {
    boolean save(String emailCode,String code);

    boolean isCode(String email);

    boolean isStatus(String email);

    void setStatus(String email);

    String deleteemail(Integer id);
}
