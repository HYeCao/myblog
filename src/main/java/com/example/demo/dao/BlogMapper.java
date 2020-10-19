package com.example.demo.dao;

import com.example.demo.dto.Blog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BlogMapper {
    Blog getBlogByID(String ID);
    List<Blog> getBlogListByIDs(List<String> IDs);
    List<Blog> getALLBlog();
    int updateBlog(Blog blog);
    int deleteBlogById(String id);
    int addBlog(Blog blog);
    List<Blog> getBlogListByCategoryId(String categoryId);
}
