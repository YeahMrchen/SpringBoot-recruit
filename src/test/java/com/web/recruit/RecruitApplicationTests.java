package com.web.recruit;

import com.web.recruit.mapper.CategoryMapper;
import com.web.recruit.mapper.PositionMapper;
import com.web.recruit.mapper.UserMapper;
import com.web.recruit.util.MailUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class RecruitApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Autowired
    PositionMapper positionMapper;

    @Autowired
    CategoryMapper categoryMapper;

    @Test
    void contextLoads() {
//        User user = new User();
//        user.setUserAccount("123445");
//        user.setUserPassword("12334");
//        user.setUserName("aaaaa");
//        System.out.println(userMapper.insertUser(user));
        System.out.println(categoryMapper.getCategoryById(1));
    }

    ApplicationContext ioc;

    @Test
    public void test() {
        System.out.println(ioc.containsBean("userMapper"));
    }

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    MailUtil mailUtil;

    @Test
    public void test01() {
        System.out.println(mailUtil.getReceiver());
    }

    @Test
    public void test02() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String s = format.format(date);
        System.out.println(date);
        System.out.println(s);
    }
}
