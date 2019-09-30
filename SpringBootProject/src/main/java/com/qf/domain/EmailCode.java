package com.qf.domain;

import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class EmailCode {

    @Id
    @GeneratedValue
    private Integer id;
    private String mailname;//存储邮箱账号
    private String code;//存储邮箱验证码
    private byte status=0;//存储0或者1,0代表未激活
}
