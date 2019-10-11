package com.qf.realm;

import com.qf.dao.AdminRepository;
import com.qf.dao.UserRepository;
import com.qf.domain.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();

        String principal = (String) principals.getPrimaryPrincipal();
        User uname = userRepository.findByUname(principal);
        if(uname.getQaunxian()==1||uname.getQaunxian()==2){
            authorizationInfo.addStringPermission("管理员");
            authorizationInfo.addStringPermission("超级管理员");
        }

        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String principal = (String) token.getPrincipal();
        User user=userRepository.findByUname(principal);
        if(user!=null){
            SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(principal,user.getPass(),getName());
            return authenticationInfo;
        }
        return null;
    }
}
