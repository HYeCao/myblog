package com.example.demo;

import com.example.demo.dto.User;
import com.example.demo.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.jws.WebParam;

@Controller
public class Index {

    @Autowired
    SysService sysService;

    @RequestMapping("/index")
    public String ftlIndex() {
        System.out.println("index");
        return "index";
    }

    @RequestMapping("/about")
    public String ftlabout() {
        System.out.println("about");
        return "about";
    }
    @RequestMapping("/blog")
    public String ftlblog() {
        System.out.println("blog");
        return "blog";
    }
    @RequestMapping("/resume")
    public String ftlresume() {
        System.out.println("resume");
        return "resume";
    }
    @RequestMapping("/article")
    public String ftlarticle() {
        System.out.println("article");
        return "article";
    }
    @RequestMapping("/show")
    public String show(Model model){
        String ID="1";
        User user=sysService.GetUser(ID);
        model.addAttribute("uid",ID);
        model.addAttribute("name",user.getUserName());
        model.addAttribute("PassWord",user.getPassword());
        model.addAttribute("Email",user.getEmail());
        return "show1";
    }
    @RequestMapping("/admin/index")
    public String ftlAdminIndex() {
        System.out.println("admin/index");
        return "admin/index";
    }
    @RequestMapping("/admin/category")
    public String ftlAdminCategory() {
        System.out.println("admin/category");
        return "admin/category";
    }
    @RequestMapping("/admin/comment")
    public String ftlAdminComment() {
        System.out.println("admin/comment");
        return "admin/comment";
    }
    @RequestMapping("/admin/article")
    public String ftlAdminArticle() {
        System.out.println("admin/article");
        return "admin/article";
    }


    @RequestMapping("/login")
    public String ftlAdminLogin() {
        System.out.println("admin/login");
        return "loginfile/login";
    }

    @RequestMapping("/admin/toLogin")
    public String toLogin() {
        System.out.println("admin/index");
        return "loginfile/login";
    }

}
