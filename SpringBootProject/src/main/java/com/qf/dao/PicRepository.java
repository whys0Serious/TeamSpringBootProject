package com.qf.dao;

import com.qf.domain.Pic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PicRepository extends JpaRepository<Pic,Integer> {

    List<Pic> findByInfo(String info);
}
