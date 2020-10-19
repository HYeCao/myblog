package com.example.demo.service.impl;


import com.example.demo.dao.BlogMapper;
import com.example.demo.dto.Blog;
import com.example.demo.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired(required = false)
    BlogMapper blogmapper;
    @Override
    public Blog getBlogByID(String ID) {
        return blogmapper.getBlogByID(ID);
    }

    @Override
    public List<Blog> getBlogListByIDs(List<String> IDs) {
        return null;
    }

    @Override
    public List<Blog> getBlogListByCategoryId(String categoryId) {
        return blogmapper.getBlogListByCategoryId(categoryId);
    }

    @Override
    public List<Blog> getALLBlog() {
        return blogmapper.getALLBlog();
    }

    @Override
    public int updateBlog(Blog blog) {
        return blogmapper.updateBlog(blog);
    }

    @Override
    public int deleteBlogById(String id) {
        return blogmapper.deleteBlogById(id);
    }

    @Override
    public int addBlog(Blog blog) {
        return blogmapper.addBlog(blog);
    }
}
