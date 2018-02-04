package com.learn.chapter11.role.service;

import com.learn.chapter11.role.dao.RoleDao;
import com.learn.chapter11.role.dao.RoleDaoImpl;
import com.learn.chapter11.role.entity.Role;

public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao = new RoleDaoImpl();

    @Override
    public Role createRole(Role role) {
        return roleDao.createRole(role);
    }

    @Override
    public void deleteRole(Long roleId) {
        roleDao.deleteRole(roleId);
    }

    @Override
    public void correlationPermissions(Long roleId, Long... permissionIds) {
        roleDao.correlationPermissions(roleId, permissionIds);
    }

    @Override
    public void uncorrelationPermissions(Long roleId, Long... permissionIds) {
        roleDao.uncorrelationPermissions(roleId, permissionIds);
    }
}
