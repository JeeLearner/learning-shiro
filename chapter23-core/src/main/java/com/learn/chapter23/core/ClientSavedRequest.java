package com.learn.chapter23.core;

import org.apache.shiro.web.util.SavedRequest;

import javax.servlet.http.HttpServletRequest;

public class ClientSavedRequest extends SavedRequest {

    private String scheme;
    private String domain;
    private int port;
    private String contextPath;
    private String backUrl;

    public ClientSavedRequest(HttpServletRequest request, String scheme) {
        super(request);
        this.scheme = scheme;
        this.domain = domain;
        this.port = port;
        this.contextPath = contextPath;
        this.backUrl = backUrl;
    }

    public String getScheme() {
        return scheme;
    }

    public String getDomain() {
        return domain;
    }

    public int getPort() {
        return port;
    }

    public String getContextPath() {
        return contextPath;
    }

    public String getBackUrl() {
        return backUrl;
    }

    @Override
    public String getRequestUrl(){
        String requestURI = getRequestURI();
        if(backUrl != null) {
            //1.如果从外部传入了successUrl（登录成功之后重定向的地址），
            //   且以http://或https://开头那么直接返回（相应的拦截器直接重定向到它即可）；
            if(backUrl.toLowerCase().startsWith("http://") || backUrl.toLowerCase().startsWith("https://")) {
                return backUrl;
            } else if(!backUrl.startsWith(contextPath)) {
                //2.如果successUrl有值但没有上下文，拼上上下文
                requestURI = contextPath + backUrl;
            } else {
                //3.否则，如果successUrl有值，直接赋值给requestUrl即可；否则，如果successUrl没值，那么requestUrl就是当前请求的地址
                requestURI = backUrl;
            }
        }

        //4.拼上url前边的schema，如http或https；
        StringBuilder requestUrl = new StringBuilder(scheme);
        //5.拼上域名
        requestUrl.append("://");
        requestUrl.append(domain);
        //6.拼上端口号
        if("http".equalsIgnoreCase(scheme) && port != 80) {
            requestUrl.append(":").append(String.valueOf(port));
        } else if("https".equalsIgnoreCase(scheme) && port != 443) {
            requestUrl.append(":").append(String.valueOf(port));
        }
        //7.拼上重定向到的地址（带上下文）
        requestUrl.append(requestURI);
        //8.如果successUrl没值，且有查询参数，拼上
        if (backUrl == null && getQueryString() != null) {
            requestUrl.append("?").append(getQueryString());
        }
        //返回该地址，相应的拦截器直接重定向到它即可
        return requestUrl.toString();
    }
}
