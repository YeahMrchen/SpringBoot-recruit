package com.web.recruit.mapper;

import com.web.recruit.entity.Category;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CategoryMapper {
    int deleteCategoryById(Integer categoryId);

    int insertCategory(Category category);

    Category getCategoryById(Integer categoryId);

    int updateCategory(Category category);

    List<Category> getCategories();
}