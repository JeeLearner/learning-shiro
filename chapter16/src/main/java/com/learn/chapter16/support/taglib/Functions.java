package com.learn.chapter16.support.taglib;

import com.learn.chapter16.organization.entity.Organization;
import com.learn.chapter16.organization.service.OrganizationService;
import com.learn.chapter16.resource.entity.Resource;
import com.learn.chapter16.resource.service.ResourceService;
import com.learn.chapter16.role.entity.Role;
import com.learn.chapter16.role.service.RoleService;
import com.learn.spring.SpringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

public class Functions {

    public static boolean in(Iterable iterable, Object element) {
        if(iterable == null) {
            return false;
        }
        return CollectionUtils.contains(iterable.iterator(), element);
    }

    public static String organizationName(Long organizationId) {
        Organization organization = getOrganizationService().findOne(organizationId);
        if(organization == null) {
            return "";
        }
        return organization.getName();
    }

    public static String organizationNames(Collection<Long> organizationIds) {
        if(CollectionUtils.isEmpty(organizationIds)) {
            return "";
        }

        StringBuilder s = new StringBuilder();
        for(Long organizationId : organizationIds) {
            Organization organization = getOrganizationService().findOne(organizationId);
            if(organization == null) {
                return "";
            }
            s.append(organization.getName());
            s.append(",");
        }

        if(s.length() > 0) {
            s.deleteCharAt(s.length() - 1);
        }

        return s.toString();
    }

    public static String roleName(Long roleId) {
        Role role = getRoleService().findOne(roleId);
        if(role == null) {
            return "";
        }
        return role.getDescription();
    }

    public static String roleNames(Collection<Long> roleIds) {
        if(CollectionUtils.isEmpty(roleIds)) {
            return "";
        }

        StringBuilder s = new StringBuilder();
        for(Long roleId : roleIds) {
            Role role = getRoleService().findOne(roleId);
            if(role == null) {
                return "";
            }
            s.append(role.getDescription());
            s.append(",");
        }

        if(s.length() > 0) {
            s.deleteCharAt(s.length() - 1);
        }

        return s.toString();
    }

    public static String resourceName(Long resourceId){
        Resource resource = getResourceService().findOne(resourceId);
        if (resource == null){
            return "";
        }
        return resource.getName();
    }

    public static String resourceNames(Collection<Long> resourceIds){
        if (CollectionUtils.isEmpty(resourceIds)){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Long resourceId: resourceIds) {
            Resource resource = getResourceService().findOne(resourceId);
            if(resource == null){
                return "";
            }
            sb.append(resource.getName());
            sb.append(",");
        }
        if (sb.length() > 0){
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private static OrganizationService organizationService;
    private static RoleService roleService;
    private static ResourceService resourceService;

    public static OrganizationService getOrganizationService() {
        if(organizationService == null) {
            organizationService = SpringUtils.getBean(OrganizationService.class);
        }
        return organizationService;
    }

    public static RoleService getRoleService() {
        if(roleService == null) {
            roleService = SpringUtils.getBean(RoleService.class);
        }
        return roleService;
    }

    public static ResourceService getResourceService() {
        if(resourceService == null) {
            resourceService = SpringUtils.getBean(ResourceService.class);
        }
        return resourceService;
    }
}
