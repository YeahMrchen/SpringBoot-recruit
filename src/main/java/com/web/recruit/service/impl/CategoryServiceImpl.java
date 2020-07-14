package com.web.recruit.service.impl;

import com.web.recruit.entity.Category;
import com.web.recruit.mapper.CategoryMapper;
import com.web.recruit.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Tracy
 * @date 2020/6/7 15:40
 */
@CacheConfig(cacheNames = "categories")
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Cacheable(key = "#id")
    @Override
    public Category getCategoryById(Integer id) {
        return categoryMapper.getCategoryById(id);
    }

    @Cacheable(keyGenerator = "allCategories")
    @Override
    public List<Category> getCategories() {
        System.out.println("getCategories");
        return categoryMapper.getCategories();
    }
}
