package com.qf.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue//生成自增主键
    private Integer uid;
    private String uname;
    private String email;//邮箱账号
    private char sex;//用单选框,存储一个字节
    private String pass;
}
