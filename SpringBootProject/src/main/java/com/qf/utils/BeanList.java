package com.qf.utils;

import lombok.Data;

import java.util.List;
@Data
public class BeanList {
    private List list;
    private Long total;
    private String mess;
    public BeanList(){

    }
    public BeanList(List list,Long total){
        this.list=list;
        this.total=total;
    }
}
