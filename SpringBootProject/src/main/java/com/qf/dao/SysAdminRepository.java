package com.qf.dao;

import com.qf.domain.SysAdmin;
import com.qf.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysAdminRepository extends JpaRepository<SysAdmin,Integer> {
    public SysAdmin findByName(String name);

}
