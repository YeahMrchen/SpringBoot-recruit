package com.web.recruit.service.impl;

import com.web.recruit.entity.HR;
import com.web.recruit.mapper.HRMapper;
import com.web.recruit.service.HRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Tracy
 * @date 2020/6/6 11:53
 */
@Service
public class HRServiceImpl implements HRService {
    @Autowired
    private HRMapper hrMapper;

    @Override
    public HR getHRByAccount(String account) {
        return hrMapper.getHRByAccount(account);
    }

    @Override
    public int loginHR(String account, String password) {
        HR hr = this.getHRByAccount(account);

        if (hr == null) {  //hr未注册
            return -1;
        }

        if (!password.equals(hr.getHrPassword())) {
            return 0;   //密码错误
        }

        return 1;
    }

    @Override
    public void updateHR(HR hr) {
        hrMapper.updateHR(hr);
    }
}
