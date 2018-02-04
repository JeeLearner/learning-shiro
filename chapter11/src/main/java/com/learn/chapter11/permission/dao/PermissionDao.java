package com.learn.chapter11.permission.dao;

import com.learn.chapter11.permission.entity.Permission;

public interface PermissionDao {
    public Permission createPermission(Permission permission);
    public void deletePermission(Long permissionId);
}
