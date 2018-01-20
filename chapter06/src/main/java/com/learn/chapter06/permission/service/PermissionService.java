package com.learn.chapter06.permission.service;

import com.learn.chapter06.permission.entity.Permission;

public interface PermissionService {
    public Permission createPermission(Permission permission);
    public void deletePermission(Long permissionId);
}
