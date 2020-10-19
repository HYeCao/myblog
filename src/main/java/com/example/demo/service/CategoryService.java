package com.example.demo.service;

import com.example.demo.dto.Category;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CategoryService {
    public List<Category> listAllCategory();
    public List<Category> listCategoryByID(String id);
    public int addCategory(Category category);
    public int updateCategory(Category category);
    public int deleteCategoryById(Long id);
    public Category getOneById(Long id);

}
