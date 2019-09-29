package com.qf.dao;


import com.qf.domain.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface TestRepository extends JpaRepository<Test,Integer> {

}
