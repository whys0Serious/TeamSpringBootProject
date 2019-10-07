package com.qf.utils;
import  lombok.Data;

import java.util.List;

@Data
public class Response<T> {
        private List<T> list;
        private long total;

}

