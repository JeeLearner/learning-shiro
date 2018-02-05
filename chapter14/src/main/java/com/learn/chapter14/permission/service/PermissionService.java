package com.learn.chapter14.permission.service;

import com.learn.chapter14.permission.entity.Permission;

public interface PermissionService {
    public Permission createPermission(Permission permission);
    public void deletePermission(Long permissionId);
}
