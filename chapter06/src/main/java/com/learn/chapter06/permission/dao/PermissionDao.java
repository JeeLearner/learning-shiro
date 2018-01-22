package com.learn.chapter06.permission.dao;

import com.learn.chapter06.permission.entity.Permission;

public interface PermissionDao {
    public Permission createPermission(Permission permission);
    public void deletePermission(Long permissionId);
}
