package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")
    public String login(Admin admin, HttpServletRequest request,String Code){
        HttpSession session = request.getSession();
        Admin one = adminService.findOne(admin);
        String validationCode = (String) session.getAttribute("validationCode");
        if(one!=null && validationCode.equals(Code)){
            session.setAttribute("login",one);
            return "redirect:/main/main.jsp";
        }else{
            return "redirect:/login.jsp";
        }

    }
    @RequestMapping("/quit")
    public String quit(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("login");
        String url="";
        return "redirect:/login.jsp";
    }

    @RequestMapping("/update")
    public @ResponseBody Map<String,Object> update(Admin admin){
        Map<String,Object> map=new HashMap<String,Object>();
        try {
            adminService.motifyPassword(admin);
            map.put("success","login.jsp");
        } catch (Exception e) {
            map.put("success",false);
            e.printStackTrace();
        }
        return map;
    }
}
