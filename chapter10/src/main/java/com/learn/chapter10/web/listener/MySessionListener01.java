package com.learn.chapter10.web.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

/**
 * 会话监听器
 */
public class MySessionListener01 implements SessionListener {
    @Override
    public void onStart(Session session) {//会话创建时触发
        System.out.println("会话创建：" + session.getId());
    }
    @Override
    public void onExpiration(Session session) {//会话过期时触发
        System.out.println("会话过期：" + session.getId());
    }
    @Override
    public void onStop(Session session) {//退出/会话过期时触发
        System.out.println("会话停止：" + session.getId());
    }
}
