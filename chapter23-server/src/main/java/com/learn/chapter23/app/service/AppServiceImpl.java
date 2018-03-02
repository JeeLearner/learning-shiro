package com.learn.chapter23.app.service;

import com.learn.chapter23.app.dao.AppDao;
import com.learn.chapter23.app.entity.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppServiceImpl implements AppService {

    @Autowired
    private AppDao appDao;

    @Override
    public App createApp(App app) {
        return appDao.createApp(app);
    }

    @Override
    public App updateApp(App app) {
        return appDao.updateApp(app);
    }

    @Override
    public void deleteApp(Long appId) {
        appDao.deleteApp(appId);
    }

    @Override
    public App findOne(Long appId) {
        return appDao.findOne(appId);
    }

    @Override
    public List<App> findAll() {
        return appDao.findAll();
    }

    @Override
    public Long findAppIdByAppKey(String appKey) {
        return appDao.findAppIdByAppKey(appKey);
    }
}