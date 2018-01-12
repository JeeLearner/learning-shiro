package com.learn.chapter03;

import org.junit.Assert;
import org.junit.Test;

public class AuthorizerTest extends BaseTest {

    @Test
    public void testIsPermitted(){
        login("classpath:shiro-authorizer.ini","JeeLearner","123");

        //判断拥有权限：user:create
        Assert.assertTrue(subject().isPermitted("user1:update"));
        Assert.assertTrue(subject().isPermitted("user2:update"));
        //通过二进制位的方式表示权限
        Assert.assertTrue(subject().isPermitted("+user1+2"));//新增权限
        Assert.assertTrue(subject().isPermitted("+user1+8"));//查看权限
        Assert.assertTrue(subject().isPermitted("+user2+10"));//新增及查看
    }
}
