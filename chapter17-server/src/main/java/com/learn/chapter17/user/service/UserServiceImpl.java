package com.learn.chapter17.user.service;

import com.learn.chapter17.support.PasswordHelper;
import com.learn.chapter17.user.dao.UserDao;
import com.learn.chapter17.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordHelper passwordHelper;

    @Override
    public User createUser(User user) {
        //加密密码
        passwordHelper.encryptPassword(user);
        return userDao.createUser(user);
    }

    @Override
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userDao.deleteUser(userId);
    }

    @Override
    public void changePassword(Long userId, String newPassword) {
        User user = userDao.findOne(userId);
        user.setPassword(newPassword);
        //加密密码
        passwordHelper.encryptPassword(user);
        userDao.updateUser(user);
    }
    @Override
    public User findOne(Long userId) {
        return userDao.findOne(userId);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
