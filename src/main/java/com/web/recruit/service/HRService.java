package com.web.recruit.service;

import com.web.recruit.entity.HR;

/**
 * @author Tracy
 * @date 2020/6/6 11:25
 */
public interface HRService {

    HR getHRByAccount(String account);

    int loginHR(String account, String password);

    void updateHR(HR hr);
}
