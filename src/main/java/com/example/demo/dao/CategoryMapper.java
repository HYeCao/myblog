package com.example.demo.dao;

import com.example.demo.dto.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CategoryMapper {
    List<Category> listAllCategory();
    List<Category> listCategoryByID(String id);
    int addCategory(Category category);
    int updateCategory(Category category);
    int deleteCategoryById(Long id);
    Category getOneById(Long id);
}
