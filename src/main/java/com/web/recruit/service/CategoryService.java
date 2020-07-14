package com.web.recruit.service;

import com.web.recruit.entity.Category;

import java.util.List;

/**
 * @author Tracy
 * @date 2020/6/7 15:37
 */
public interface CategoryService {

    Category getCategoryById(Integer id);

    List<Category> getCategories();
}
