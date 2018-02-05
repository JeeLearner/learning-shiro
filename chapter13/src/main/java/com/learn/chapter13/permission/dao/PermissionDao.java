package com.learn.chapter13.permission.dao;

import com.learn.chapter13.permission.entity.Permission;

public interface PermissionDao {
    public Permission createPermission(Permission permission);
    public void deletePermission(Long permissionId);
}
