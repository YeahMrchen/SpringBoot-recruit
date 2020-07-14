package com.web.recruit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Tracy
 * @date 2020/6/6 17:35
 */
@Controller
public class PageController {

    /**
     * 去注册界面
     *
     * @return
     */
    @GetMapping(value = "/toRegister")
    public String userRegister() {
        return "redirect:/register.html";
    }

    /**
     * 返回用户登录
     * @return
     */
    @GetMapping(value = "/toUserLogin")
    public String toUserLogin() {
        return "redirect:/login.html";
    }

    /**
     * 返回hr登录
     * @return
     */
    @GetMapping(value = "/toHRLogin")
    public String toHRLogin() {
        return "redirect:/hr_login.html";
    }

    /**
     * 错误页面返回
     * @param request
     * @return
     */
    @GetMapping("/return")
    public String returnIndex(HttpServletRequest request) {
        if (request.getSession().getAttribute("user") != null) {
            return "redirect:/toIndex";
        }

        return "redirect:/hr/unHandle";
    }
    /**
     * 去用户主页
     * @return
     */
    @GetMapping(value = "/toIndex")
    public String userIndex() {
        return "redirect:/index.html";
    }

    /**
     * 去hr信息页
     * @return
     */
    @GetMapping(value = "/toHRInfo")
    public String toHrInfo() {
        return "redirect:/hr/toEditInfo";
    }

    /**
     * 登出
     * @param request
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();

        System.out.println("logout");
        return "redirect:/login.html";
    }

    /**
     * 去用户反馈信息页面
     * @return
     */
    @GetMapping("/toSend")
    public String toSend() {
        return "redirect:/send.html";
    }
}
