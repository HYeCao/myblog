package com.example.demo.service.impl;

import com.example.demo.dao.CategoryMapper;
import com.example.demo.dto.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired(required = false)
    CategoryMapper categoryMapper;

    @Override
    public List<Category> listAllCategory() {
        return categoryMapper.listAllCategory();
    }

    @Override
    public List<Category> listCategoryByID(String id) {
        return categoryMapper.listCategoryByID(id);
    }

    @Override
    public int addCategory(Category category) {
        return categoryMapper.addCategory(category);
    }

    @Override
    public int updateCategory(Category category) {
        return categoryMapper.updateCategory(category);
    }

    @Override
    public int deleteCategoryById(Long id) {
        return categoryMapper.deleteCategoryById(id);
    }

    public Category getOneById(Long id) {
        return categoryMapper.getOneById(id);
    }
}
