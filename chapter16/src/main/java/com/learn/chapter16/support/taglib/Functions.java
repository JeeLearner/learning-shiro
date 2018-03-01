package com.learn.chapter16.support.taglib;

import com.learn.chapter16.organization.entity.Organization;
import com.learn.chapter16.organization.service.OrganizationService;
import com.learn.chapter16.resource.entity.Resource;
import com.learn.chapter16.resource.service.ResourceService;
import com.learn.chapter16.role.entity.Role;
import com.learn.chapter16.role.service.RoleService;
import com.learn.chapter16.support.Constants;
import com.learn.chapter16.user.entity.User;
import com.learn.chapter16.user.service.UserService;
import com.learn.spring.SpringUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
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

    public static String username(Long userId) {
        User user = getUserService().findOne(userId);
        if(user == null) {
            return "";
        }
        return user.getUsername();
    }

    public static String principal(Session session) {
        PrincipalCollection principalCollection =
                (PrincipalCollection) session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);

        return (String)principalCollection.getPrimaryPrincipal();
    }
    public static boolean isForceLogout(Session session) {
        return session.getAttribute(Constants.SESSION_FORCE_LOGOUT_KEY) != null;
    }

    private static OrganizationService organizationService;
    private static RoleService roleService;
    private static ResourceService resourceService;
    private static UserService userService;

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

    public static UserService getUserService() {
        if(userService == null) {
            userService = SpringUtils.getBean(UserService.class);
        }
        return userService;
    }
}
