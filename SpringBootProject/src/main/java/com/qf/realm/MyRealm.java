package com.qf.realm;

import com.qf.dao.AdminRepository;
import com.qf.dao.SysAdminRepository;
import com.qf.dao.UserRepository;
import com.qf.domain.Admin;
import com.qf.domain.SysAdmin;
import com.qf.domain.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private SysAdminRepository sysAdminRepository;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String principal = (String) token.getPrincipal();
        User user=userRepository.findByUname(principal);
        if(user!=null){
            SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(principal,user.getPass(),getName());
            return authenticationInfo;
        }
        SysAdmin sysAdmin = sysAdminRepository.findByName(principal);
        if(sysAdmin!=null){
            SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(principal,sysAdmin.getPass(),getName());
            return authenticationInfo;
        }
        Admin admin = adminRepository.findByName(principal);
        if(admin!=null){
            SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(principal,admin.getPass(),getName());
            return authenticationInfo;
        }
        return null;
    }
}
