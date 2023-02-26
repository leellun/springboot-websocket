package com.newland.socket.controller;

import com.newland.socket.config.UserConfig;
import com.newland.socket.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginController {
    @RequestMapping("/loginvalidate")
    public String loginvalidate(@RequestParam("username") String username, @RequestParam("password") String pwd, HttpSession httpSession) {
        if (username == null) {
            return "login";
        }

        User user = UserConfig.getUser(username);
        if (user != null && "1234".equals(pwd)) {
            long uid = user.getUid();
            httpSession.setAttribute("uid", uid);
            return "chatroom";
        }
        return "fail";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession httpSession) {
        return "login";
    }

    @RequestMapping(value = "/currentuser", method = RequestMethod.GET)
    @ResponseBody
    public User currentuser(HttpSession httpSession) {
        Long uid = (Long) httpSession.getAttribute("uid");
        User user = UserConfig.getUser(uid);
        String name = user.getName();
        return new User(uid, name);
    }
}
