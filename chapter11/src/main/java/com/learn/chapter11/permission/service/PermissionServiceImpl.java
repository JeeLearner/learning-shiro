package com.learn.chapter11.permission.service;

import com.learn.chapter11.permission.dao.PermissionDao;
import com.learn.chapter11.permission.dao.PermissionDaoImpl;
import com.learn.chapter11.permission.entity.Permission;

public class PermissionServiceImpl implements PermissionService {
    private PermissionDao permissionDao = new PermissionDaoImpl();

    @Override
    public Permission createPermission(Permission permission) {
        return permissionDao.createPermission(permission);
    }

    @Override
    public void deletePermission(Long permissionId) {
        permissionDao.deletePermission(permissionId);
    }
}
