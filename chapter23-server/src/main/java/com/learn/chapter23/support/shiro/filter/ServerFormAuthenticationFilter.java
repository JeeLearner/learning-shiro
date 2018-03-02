package com.learn.chapter23.support.shiro.filter;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServerFormAuthenticationFilter extends FormAuthenticationFilter {

    /**
     * 因为是多项目登录，比如如果是从其他应用中重定向过来的，
     *    首先检查Session中是否有“authc.fallbackUrl”属性，
     *    如果有就认为它是默认的重定向地址；
     *    否则使用Server自己的successUrl作为登录成功后重定向到的地址。
     * @param request
     * @param response
     * @throws Exception
     */
    @Override
    protected void issueSuccessRedirect(ServletRequest request, ServletResponse response) throws Exception {
        String fallbackUrl = (String) getSubject(request, response)
                .getSession().getAttribute("authc.fallbackUrl");
        if(StringUtils.isEmpty(fallbackUrl)) {
            fallbackUrl = getSuccessUrl();
        }
        WebUtils.redirectToSavedRequest(request, response, fallbackUrl);
    }

}