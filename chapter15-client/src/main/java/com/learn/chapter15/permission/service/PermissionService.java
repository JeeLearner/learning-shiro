package com.learn.chapter15.permission.service;

import com.learn.chapter15.permission.entity.Permission;

public interface PermissionService {
    public Permission createPermission(Permission permission);
    public void deletePermission(Long permissionId);
}
