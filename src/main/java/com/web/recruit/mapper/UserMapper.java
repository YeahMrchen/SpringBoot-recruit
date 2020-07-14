package com.web.recruit.mapper;

import com.web.recruit.entity.User;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
    int deleteUserById(Integer userId);

    int insertUser(User user);

    User getUserById(Integer userId);

    User getUserByAccount(String account);

    User getUserByResumeId(Integer resumeId);

    int updateUser(User user);

}