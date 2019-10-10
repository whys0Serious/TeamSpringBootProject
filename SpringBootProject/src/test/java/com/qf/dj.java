package com.qf;

import java.math.BigDecimal;

public class dj {
    public static void main(String[] args) {

        BigDecimal a=new BigDecimal(5.001);
        BigDecimal b=new BigDecimal(5);

        System.out.println(a.add(b));
        Double c=1000000.001;
        Double d=1.01;
        System.out.println(c+d);
    }
}
