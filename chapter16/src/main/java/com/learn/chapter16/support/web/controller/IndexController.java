package com.learn.chapter16.support.web.controller;

import com.learn.chapter16.resource.entity.Resource;
import com.learn.chapter16.resource.service.ResourceService;
import com.learn.chapter16.support.bind.annotation.CurrentUser;
import com.learn.chapter16.user.entity.User;
import com.learn.chapter16.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;
    @Autowired
    private ResourceService resourceService;

    @RequestMapping(value = "/")
    public String index(@CurrentUser User loginUser, Model model) {
        Set<String> permissions = userService.findPermissions(loginUser.getUsername());
        List<Resource> menus = resourceService.findMenus(permissions);
        model.addAttribute("menus", menus);
        return "index";
    }

    @RequestMapping(value = "/welcome")
    public String welcome(){
        return "welcome";
    }
}
