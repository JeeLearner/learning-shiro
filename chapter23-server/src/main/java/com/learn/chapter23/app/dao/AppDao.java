package com.learn.chapter23.app.dao;

import com.learn.chapter23.app.entity.App;

import java.util.List;

public interface AppDao {

    public App createApp(App app);
    public App updateApp(App app);
    public void deleteApp(Long appId);

    public App findOne(Long appId);
    public List<App> findAll();

    Long findAppIdByAppKey(String appKey);
}