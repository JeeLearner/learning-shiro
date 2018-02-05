package com.learn.chapter13.user.dao;

import com.learn.chapter13.user.entity.User;

import java.util.Set;

public interface UserDao {

    public User createUser(User user);
    //public void changePassword(Long userId, String newPassword);
    public void correlationRoles(Long userId, Long... roleIds);
    public void uncorrelationRoles(Long userId, Long... roleIds);
    public User findByUsername(String username);
    public Set<String> findRoles(String username);
    public Set<String> findPermissions(String username);

    public User findOne(Long userId);
    public void updateUser(User user);
    public void deleteUser(Long userId);
}
