package com.example.demo.controller;

import com.example.demo.dto.User;
import com.example.demo.service.SysService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/admin")
@Controller
public class LoginController {

    @Autowired
    SysService sysService;

    /**
     * 后台登录操作
     *
     * @param request
     * @return
     */
    @PostMapping("/userLogin")
    public String login(String username, String password, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("username:" + username + " password:" + password);

        // 对用户账号进行验证,是否正确
        User user = sysService.getUserByNamePassword(username, password);

        if (user.getUserName().equals(username) && user.getPassword().equals(password)) {
            System.out.println("正在进行登录");
            request.getSession().setAttribute("user", user);
//            response.sendRedirect(request.getContextPath() + "/admin/index");
            return "admin/index";

        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
        return null;
    }



    @PostMapping("/userLoginPlus")
    public String loginPlus(Model model, String username, String password, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try{
            subject.login(token);
            User user = sysService.getUserByNamePassword(username, password);
            request.getSession().setAttribute("user", user);

            return "admin/index";

        }catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误！");

            return "login";
        } catch (AuthenticationException e) {
            model.addAttribute("msg", "用户名不存在");

            return "login";
        }

    }



}
