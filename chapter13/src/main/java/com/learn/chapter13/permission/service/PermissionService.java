package com.learn.chapter13.permission.service;

import com.learn.chapter13.permission.entity.Permission;

public interface PermissionService {
    public Permission createPermission(Permission permission);
    public void deletePermission(Long permissionId);
}
