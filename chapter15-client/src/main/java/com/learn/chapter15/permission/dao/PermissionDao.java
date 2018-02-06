package com.learn.chapter15.permission.dao;

import com.learn.chapter15.permission.entity.Permission;

public interface PermissionDao {
    public Permission createPermission(Permission permission);
    public void deletePermission(Long permissionId);
}
