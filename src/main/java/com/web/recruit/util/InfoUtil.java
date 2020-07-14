package com.web.recruit.util;

import com.web.recruit.entity.HR;
import com.web.recruit.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Tracy
 * @date 2020/6/6 10:48
 */
public class InfoUtil {

    /**
     * 返回当前登录user
     */
    public static User getLoginUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(null == session){
            return null;
        }
        return (User)session.getAttribute("user");
    }

    /**
     * 返回当前登录HR
     */
    public static HR getLoginHR(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(null == session){
            return null;
        }
        return (HR) session.getAttribute("hr");
    }
}
