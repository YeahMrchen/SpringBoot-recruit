package com.web.recruit.service.impl;

import com.web.recruit.entity.User;
import com.web.recruit.mapper.UserMapper;
import com.web.recruit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Tracy
 * @date 2020/6/5 22:58
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByAccount(String account) {
        return userMapper.getUserByAccount(account);
    }

    @Override
    public User getUserByResumeId(Integer resumeId) {
        return userMapper.getUserByResumeId(resumeId);
    }

    @Override
    public int loginUser(String account, String password) {
        User user = this.getUserByAccount(account);

        if (user == null) {  //用户未注册
            return -1;
        }

        if (!password.equals(user.getUserPassword())) {
            return 0;   //密码错误
        }

        return 1;
    }

    @Override
    public User getUserById(Integer userId) {
        return userMapper.getUserById(userId);
    }

    @Override
    public int saveUser(User user) {
        User tmp = userMapper.getUserByAccount(user.getUserAccount());

        if (tmp != null) {
            return 0;
        }

        //插入用户数据
        userMapper.insertUser(user);

        return 1;
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }
}
