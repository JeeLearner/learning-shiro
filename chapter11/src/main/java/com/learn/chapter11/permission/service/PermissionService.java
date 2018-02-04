package com.learn.chapter11.permission.service;

import com.learn.chapter11.permission.entity.Permission;

public interface PermissionService {
    public Permission createPermission(Permission permission);
    public void deletePermission(Long permissionId);
}
