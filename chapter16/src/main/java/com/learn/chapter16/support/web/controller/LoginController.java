package com.learn.chapter16.support.web.controller;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @RequestMapping(value = {"/{login:login;?.*}"})
    public String showLoginForm(HttpServletRequest req, Model model) {
        String exceptionClassName = (String)req.getAttribute("shiroLoginFailure");
        String error = null;
        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if("jCaptcha.error".equals(exceptionClassName)) {
            error = "验证码错误";
        } else if(exceptionClassName != null) {
            error = "其他错误：" + exceptionClassName;
        }
        model.addAttribute("error", error);

        if(req.getParameter("forceLogout") != null) {
            model.addAttribute("error", "您已经被管理员强制退出，请重新登录");
        }
        return "login";
    }
}
