package com.learn.chapter14.permission.dao;

import com.learn.chapter14.permission.entity.Permission;

public interface PermissionDao {
    public Permission createPermission(Permission permission);
    public void deletePermission(Long permissionId);
}
