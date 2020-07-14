package com.web.recruit.config.redis;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;

/**
 * @author Tracy
 * @date 2020/6/7 22:22
 */
@Configuration
public class KeyGeneratorConfiguration {

    /**
     * 岗位种类
     * @return
     */
    @Bean("allCategories")
    public KeyGenerator categories() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return "all";
            }
        };
    }

    /**
     * 所有岗位
     * @return
     */
    @Bean("allPositions")
    public KeyGenerator allPositions() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return "all";
            }
        };
    }

    /**
     * 岗位标签获取岗位
     * @return
     */
    @Bean("byCategoryId")
    public KeyGenerator positionsByCategoryId() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return "category_of_" + params[0];
            }
        };
    }

    /**
     * 公司Id获取岗位
     * @return
     */
    @Bean("byCompanyId")
    public KeyGenerator positionsByCompanyId() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return "company_of_" + params[0];
            }
        };
    }

    /**
     * 关键字获取岗位
     * @return
     */
    @Bean("byKeyword")
    public KeyGenerator positionsByKey() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return "keyword_of_" + params[0];
            }
        };
    }

    @Bean("allCompanies")
    public KeyGenerator allCompanies() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                return "all";
            }
        };
    }
}
