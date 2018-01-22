package com.learn.chapter06.common;

import com.learn.chapter06.user.entity.User;
import com.learn.chapter06.user.service.UserService;
import com.learn.chapter06.user.service.UserServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class UserRealm extends AuthorizingRealm {
    private UserService userService = new UserServiceImpl();

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String username = (String)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(userService.findRoles(username));
        simpleAuthorizationInfo.setStringPermissions(userService.findPermissions(username));
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String)token.getPrincipal();
        User user = userService.findByUsername(username);
        if (user == null){
            throw new UnknownAccountException();//没找到账号
        }
        if (Boolean.TRUE.equals(user.getLocked())){
            throw new LockedAccountException();//账号锁定
        }
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得不好可以自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
          user.getUsername(),
          user.getPassword(),
          ByteSource.Util.bytes(user.getCredentialsSalt()), //salt = username+salt
          getName() //realm name
        );
        return authenticationInfo;
    }
}
