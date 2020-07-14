package com.web.recruit.controller;

import com.web.recruit.entity.HR;
import com.web.recruit.entity.User;
import com.web.recruit.util.InfoUtil;


import javax.servlet.http.HttpServletRequest;

/**
 * @author Tracy
 * @date 2020/6/6 21:59
 */
public class BaseController {

    /**
     * 获取当前用户
     * @param request
     * @return
     */
    public User getUser(HttpServletRequest request) {
        return InfoUtil.getLoginUser(request);
    }

    /**
     * 获取当前HR
     * @param request
     * @return
     */
    public HR getHR(HttpServletRequest request) {
        return InfoUtil.getLoginHR(request);
    }

    /**
     * 获取当前用户Id
     * @param request
     * @return
     */
    public Integer getUserId(HttpServletRequest request) {
        return this.getUser(request).getUserId();
    }

    /**
     * 获取当前HR Id
     * @param request
     * @return
     */
    public Integer getHRId(HttpServletRequest request) {
        return this.getHR(request).getHrId();
    }


}
