package com.web.recruit.mapper;

import com.web.recruit.entity.HR;
import org.springframework.stereotype.Component;

@Component
public interface HRMapper {
    int deleteHRById(Integer hrId);

    int insertHR(HR hr);

    HR getHRById(Integer hrId);

    HR getHRByAccount(String account);

    int updateHR(HR hr);

}