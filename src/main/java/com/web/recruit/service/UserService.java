package com.web.recruit.service;

import com.web.recruit.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author Tracy
 * @date 2020/6/5 22:55
 */
@Service
public interface UserService {
    int loginUser(String account, String password);

    User getUserById(Integer userId);

    User getUserByAccount(String account);

    User getUserByResumeId(Integer resumeId);

    int saveUser(User user);

    void updateUser(User user);
}
