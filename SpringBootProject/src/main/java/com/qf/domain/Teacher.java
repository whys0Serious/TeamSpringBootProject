package com.qf.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

@Data
@Entity
@Table(name = "course_teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "th_id")
    private Integer thid;
    @Column(name = "th_sex")
    private String thsex;
    @Column(name = "th_email")
    private String themail;
    @Column(name = "th_detail")
    private String thdetail;
    @Column(name = "th_name")
    private String thname;
    @Column(name = "th_pic")
    private String thpic;

}
