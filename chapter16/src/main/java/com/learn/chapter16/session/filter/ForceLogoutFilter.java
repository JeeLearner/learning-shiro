package com.learn.chapter16.session.filter;

import com.learn.chapter16.support.Constants;
import org.apache.shiro.session.Session;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ForceLogoutFilter extends AccessControlFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        Session session = getSubject(servletRequest, servletResponse).getSession(false);
        if(session == null) {
            return true;
        }
        return session.getAttribute(Constants.SESSION_FORCE_LOGOUT_KEY) == null;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        try {
            getSubject(servletRequest, servletResponse).logout();//强制退出
        } catch (Exception e) {/*ignore exception*/}

        String loginUrl = getLoginUrl() + (getLoginUrl().contains("?") ? "&" : "?") + "forceLogout=1";
        WebUtils.issueRedirect(servletRequest, servletResponse, loginUrl);
        return false;
    }
}
