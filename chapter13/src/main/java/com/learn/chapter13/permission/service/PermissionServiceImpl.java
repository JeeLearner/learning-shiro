package com.learn.chapter13.permission.service;

import com.learn.chapter13.permission.dao.PermissionDao;
import com.learn.chapter13.permission.entity.Permission;

public class PermissionServiceImpl implements PermissionService {
    private PermissionDao permissionDao;
    public void setPermissionDao(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }

    @Override
    public Permission createPermission(Permission permission) {
        return permissionDao.createPermission(permission);
    }

    @Override
    public void deletePermission(Long permissionId) {
        permissionDao.deletePermission(permissionId);
    }
}
