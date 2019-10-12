package com.qf.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Course {
        @GeneratedValue
        @Id
        private Integer cid;
        private String cname;//克明
        private Float price;
        private Integer details;//销量
        private String info;
        private Date time;
        private String mainpic;//图片
        private Integer pic_num;//图片数量
        @Column(name = "ct_id")
        private Integer ctid;
        @Column(name = "th_id")
        private Integer thid;//老师的id
        @Column(name = "cou_time")
        private Float coutime;  //课时
        private String thname;
        private String thpic;

}
