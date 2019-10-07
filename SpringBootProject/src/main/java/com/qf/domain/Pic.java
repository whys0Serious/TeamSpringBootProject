package com.qf.domain;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "course_pic")
@Data
public class Pic{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pic_num;
    private String pic1;
    private String pic2;
    private String pic3;
    private String pic4;
    private String pic5;
    private String info;

}
