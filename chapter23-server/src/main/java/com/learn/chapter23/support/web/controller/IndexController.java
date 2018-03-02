package com.learn.chapter23.support.web.controller;

import com.learn.chapter23.authorization.service.AuthorizationService;
import com.learn.chapter23.resource.entity.Resource;
import com.learn.chapter23.resource.service.ResourceService;
import com.learn.chapter23.support.Constants;
import com.learn.chapter23.support.bind.annotation.CurrentUser;
import com.learn.chapter23.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

@Controller
public class IndexController {

    @Autowired
    private ResourceService resourceService;
    @Autowired
    private AuthorizationService authorizationService;

    @RequestMapping(value = "/")
    public String index(@CurrentUser User loginUser, Model model) {
        Set<String> permissions = authorizationService.findPermissions(Constants.SERVER_APP_KEY, loginUser.getUsername());
        List<Resource> menus = resourceService.findMenus(permissions);
        model.addAttribute("menus", menus);
        return "index";
    }

    @RequestMapping(value = "/welcome")
    public String welcome(){
        return "welcome";
    }
}
