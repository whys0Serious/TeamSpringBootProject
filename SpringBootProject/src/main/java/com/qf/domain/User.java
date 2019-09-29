package com.qf.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "test")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

}
