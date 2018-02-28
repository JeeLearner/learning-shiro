package com.learn.chapter16.runas.dao;

import java.util.List;

public interface UserRunAsDao {

    //授权身份
    public void grantRunAs(Long fromUserId, Long toUserId);
    //回收身份
    public void revokeRunAs(Long fromUserId, Long toUserId);
    //关系存在判断
    public boolean exists(Long fromUserId, Long toUserId);

    public List<Long> findFromUserIds(Long toUserId);
    public List<Long> findToUserIds(Long fromUserId);
}
