package com.qf.controller;

import com.qf.domain.Pic;
import com.qf.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PicController {

    @Autowired
    private PicService picService;

    @RequestMapping("/findShowPic/{info}")
    public List<Pic> findShowPic(@PathVariable String info){
        return picService.findShowPic(info);
    }
}
