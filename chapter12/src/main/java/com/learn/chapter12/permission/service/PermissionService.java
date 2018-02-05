package com.learn.chapter12.permission.service;

import com.learn.chapter12.permission.entity.Permission;

public interface PermissionService {
    public Permission createPermission(Permission permission);
    public void deletePermission(Long permissionId);
}
