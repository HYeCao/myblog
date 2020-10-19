package com.example.demo.service;

import com.example.demo.dto.Blog;

import java.util.List;

public interface BlogService {
    public Blog getBlogByID(String ID);
    public List<Blog> getBlogListByIDs(List<String> IDs);
    public List<Blog> getBlogListByCategoryId(String categoryId);
    public List<Blog> getALLBlog();
    public int updateBlog(Blog blog);
    public int deleteBlogById(String id);
    public int addBlog(Blog blog);
}
