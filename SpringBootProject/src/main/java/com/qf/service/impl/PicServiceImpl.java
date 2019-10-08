package com.qf.service.impl;

import com.qf.dao.PicRepository;
import com.qf.domain.Pic;
import com.qf.service.PicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PicServiceImpl implements PicService {

    @Autowired
    private PicRepository picRepository;

    @Override
    public List<Pic> findShowPic(String info) {
        return picRepository.findByInfo(info);
    }
}
