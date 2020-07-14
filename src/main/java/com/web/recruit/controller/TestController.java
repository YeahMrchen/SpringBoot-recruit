package com.web.recruit.controller;

import com.web.recruit.entity.Category;
import com.web.recruit.mapper.CategoryMapper;
import com.web.recruit.service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author Tracy
 * @date 2020/6/6 11:20
 */
@Controller
public class TestController {

    @RequestMapping("/hello")
    public String test01() {
        return "user_login";
    }

    @Autowired
    private CategoryMapper categoryMapper;

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/searchCate/{id}")
    public Category searchByCategory(@PathVariable("id") Integer categoryId) {

        return categoryMapper.getCategoryById(categoryId);
    }


    @Autowired
    private CategoryServiceImpl categoryService;

    @CrossOrigin
    @ResponseBody
    @RequestMapping("/testCate")
    public List<Category> test02() {
        return categoryService.getCategories();
    }


    @RequestMapping("/user")
    public String test03() {
        System.out.println("toIndex");
        return "redirect:/toIndex";
    }

}
