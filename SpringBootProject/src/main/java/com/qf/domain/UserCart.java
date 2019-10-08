package com.qf.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * 购物车实体类
 * 关联实体类有:课程实体,用户实体
 */
@Entity
@Data
@Table(name = "user_cart")
public class UserCart {
    @Id
    @GeneratedValue
    @Column(name = "cart_id")
    private Integer cartId;
    @Column(name = "cid")
    private Integer cid;
    @Column(name = "uid")
    private Integer uid;
    @Column(name = "number")
    private Integer number;
}
