package com.web.recruit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.web.recruit.mapper")
@EnableCaching
@SpringBootApplication
public class RecruitApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(RecruitApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(RecruitApplication.class);
    }
}
