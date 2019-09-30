package com.qf.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Admin {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String pass;
    private char sex;
    private String email;//邮箱
    @DateTimeFormat
    private Date birth;//出生日期
    private String addr;//住址
    private String self;//自我描述
}
