package com.lack.homework.controller;

import com.lack.homework.dao.StudyUserDaoImpl;
import com.lack.homework.entity.StudyUser;
import com.lack.homework.service.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    StudyUserDaoImpl studyUserDao;

    @Autowired
    LoginServiceImpl loginService;

    @GetMapping("/Login")
    public String Login(){
        return "login";
    }

    @RequestMapping("/user/login")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password,
                        HttpSession session,
                        Model model){
        String login = loginService.login(username, password);
        if (login.equals("dashboard")){
            session.setAttribute("LoginUser",username);
            model.addAttribute("LoginUser",username);
            return "dashboard";
        }else {
            model.addAttribute("msg","用户名或者密码错误");
            return "login";
        }

    }
}
