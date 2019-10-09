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
        private String cname;
        private Float price;
        private String details;
        private String info;
        private Date time;
        private String mainpic;
        private Integer pic_num;
        @Column(name = "ct_id")
        private Integer ctid;
        @Column(name = "th_id")
        private Integer thid;
        @Column(name = "cou_time")
        private float coutime;  //课时

}
