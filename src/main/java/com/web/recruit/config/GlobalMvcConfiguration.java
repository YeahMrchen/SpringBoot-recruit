package com.web.recruit.config;

import com.web.recruit.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Tracy
 * @date 2020/6/6 12:12
 */
@Configuration
public class GlobalMvcConfiguration implements WebMvcConfigurer {

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/", "/login.html", "/hr_login.html",
                                "/user/login", "/toRegister", "/register.html", "/user/register",
                                "/toUserLogin", "/toHRLogin", "/hr/login", "/sources/**");
            }

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                //配置user视图
                registry.addViewController("/").setViewName("user/user_login");
                registry.addViewController("/login.html").setViewName("user/user_login");
                registry.addViewController("/register.html").setViewName("user/register");
                registry.addViewController("/index.html").setViewName("user/index");
                registry.addViewController("/list.html").setViewName("user/search_list");
                registry.addViewController("/detail.html").setViewName("user/position_detail");
                registry.addViewController("/info.html").setViewName("user/user_info");


                //配置hr视图
                registry.addViewController("/hr_login.html").setViewName("hr/hr_login");
                registry.addViewController("/hr_info.html").setViewName("hr/hr_info");
                registry.addViewController("/hr_unhandled.html").setViewName("hr/hr_unhandled");
                registry.addViewController("/hr_passed.html").setViewName("hr/hr_passed");
                registry.addViewController("/hr_rejected.html").setViewName("hr/hr_rejected");
                registry.addViewController("/publish.html").setViewName("hr/publish_position");
                registry.addViewController("/resume.html").setViewName("hr/hr_showResume");
                registry.addViewController("/send.html").setViewName("user/send");
            }

        };
    }

}
