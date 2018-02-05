package com.learn.chapter12.permission.dao;

import com.learn.chapter12.permission.entity.Permission;

public interface PermissionDao {
    public Permission createPermission(Permission permission);
    public void deletePermission(Long permissionId);
}
