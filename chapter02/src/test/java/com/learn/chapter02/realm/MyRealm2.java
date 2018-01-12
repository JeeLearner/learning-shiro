package com.learn.chapter02.realm;


import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * 自定义MyRealm1
 */
public class MyRealm2 implements Realm{

    @Override
    public String getName() {
        return "myRealm2";
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        //仅支持UsernamePasswordToken类型的Token
        return token instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String)token.getPrincipal();
        String password = new String((char[])token.getCredentials());
        /*UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        String username1 = upToken.getUsername();
        String password1 = new String(upToken.getPassword());*/

        if (!"lyd".equals(username)){
            throw new UnknownAccountException();//如果用户名错误
        }
        if(!"123".equals(password)){
            throw new IncorrectCredentialsException();//如果密码错误
        }
        //如果身份认证验证成功，返回一个AuthenticationInfo实现；
        return new SimpleAuthenticationInfo(username,password,getName());
    }
}
