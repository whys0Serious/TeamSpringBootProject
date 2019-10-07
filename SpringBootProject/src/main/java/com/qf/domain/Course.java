package com.qf.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import java.util.Date;

@Data
@Entity
public class Course {


        @GeneratedValue
        @Id
        private Integer cid;
        private String cname;
        private float price;
        private String details;
        private String info;
        private Date time;
        private String mainpic;
        private Integer pic_num;
        private Integer ct_id;
        private Integer th_id;

}