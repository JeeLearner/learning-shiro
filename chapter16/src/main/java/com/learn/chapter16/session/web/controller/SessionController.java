package com.learn.chapter16.session.web.controller;

import com.learn.chapter16.support.Constants;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collection;

@RequiresPermissions("session:*")
@Controller
@RequestMapping("/sessions")
public class SessionController {

    @Autowired
    private SessionDAO sessionDAO;

    /**
     * 展示所有在线会话列表
     * @param model
     * @return
     */
    @RequestMapping()
    public String list(Model model){
        Collection<Session> activeSessions = sessionDAO.getActiveSessions();
        model.addAttribute("sessions", activeSessions);
        model.addAttribute("sessionCount", activeSessions.size());
        return "sessions/list";
    }

    /**
     * 强制退出某一个会话
     * @param sessionId
     * @param redirectAttributes
     * @return
     */
    @RequestMapping("/{sessionId}/forceLogout")
    public String forceLogout(
            @PathVariable("sessionId") String sessionId, RedirectAttributes redirectAttributes) {
        try {
            Session session = sessionDAO.readSession(sessionId);
            if(session != null) {
                session.setAttribute(Constants.SESSION_FORCE_LOGOUT_KEY, Boolean.TRUE);
            }
        } catch (Exception e) {/*ignore*/}
        redirectAttributes.addFlashAttribute("msg", "强制退出成功！");
        return "redirect:/sessions";
    }


}
