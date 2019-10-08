package com.qf.dao;

import com.qf.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    Teacher findByThid(Integer thid);
}
