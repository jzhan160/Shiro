package com.demo.test.controller;

import com.demo.test.service.AnnotationService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {
    @Autowired
    private AnnotationService annotationService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String index(){
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password, HttpSession session) {
        UsernamePasswordToken token = new UsernamePasswordToken(
                username, password);
        token.setRememberMe(true);
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        session.setAttribute("key","value");
        return "redirect: /success";
    }

    @RequestMapping("/success")
    public String success(){
        return "/Success";
    }

    @RequestMapping("/logout")
    public String logout(){
        return "/login";
    }
    @RequestMapping("/user")
    public String user(){
        return "/user";
    }
    @RequestMapping("/admin")
    public String admin(){
        return "/admin";
    }

    @RequestMapping("/testShiroAnnotation")
    public void testShiroAnnotation(){
       annotationService.testShiroAnnotation();
    }

    @RequestMapping("/Unauthorized")
    public String unauthorized(){
        return "/Unauthorized";
    }
}
