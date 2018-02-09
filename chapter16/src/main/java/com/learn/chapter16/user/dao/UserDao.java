package com.learn.chapter16.user.dao;

import com.learn.chapter16.user.entity.User;

import java.util.List;
import java.util.Set;

public interface UserDao {

    public User createUser(User user);
    public User updateUser(User user);
    public void deleteUser(Long userId);

    User findOne(Long userId);

    List<User> findAll();

    User findByUsername(String username);
}
