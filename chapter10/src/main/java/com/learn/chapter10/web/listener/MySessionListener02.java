package com.learn.chapter10.web.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListenerAdapter;

/**
 * 只监听某一个事件
 */
public class MySessionListener02 extends SessionListenerAdapter {
    @Override
    public void onStart(Session session) {
        System.out.println("会话创建：" + session.getId());
    }
}
