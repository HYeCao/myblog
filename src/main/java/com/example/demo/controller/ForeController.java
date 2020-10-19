package com.example.demo.controller;

import com.example.demo.dto.Blog;
import com.example.demo.dto.Category;
import com.example.demo.dto.Comment;
import com.example.demo.service.BlogService;
import com.example.demo.service.CategoryService;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class ForeController {

    @Autowired
    BlogService blogservice;
    @Autowired
    CommentService commentService;
    @Autowired
    CategoryService categoryService;
    /**
     * 通过文章的ID获取对应的文章信息
     *
     * @param id
     * @return 自己封装好的文章信息类
     */
    @GetMapping("/article/{id}")
    public Blog getArticleById(@PathVariable String id) {
        System.out.println("test:  article"+id);
        System.out.println(blogservice.getBlogByID(id).toString());
        updateArticleViewsById(blogservice.getBlogByID(id));
        return blogservice.getBlogByID(id);
    }
    public int updateArticleViewsById(Blog blog) {
        int view = 0;
        if(blog.getViews() == null)view = 1;
        else {
            view = Integer.valueOf(blog.getViews()) + 1;
        }
        blog.setViews(String.valueOf(view));
        return blogservice.updateBlog(blog);
    }

    /**
     * 添加留言
     * @param
     * @return
     */
    @PostMapping("/comment/article")
    public int addArticleComment(@RequestBody Comment comment) {
        System.out.println("comment/article/id ");
        System.out.println(comment.toString());
        comment.setDate(new Date());
//        return commentService.listAllArticleCommentById(id);
        return commentService.addComment(comment);
    }
    /**
     *
     * @return
     */
    @GetMapping("/comment/list")
    public List<Comment> listCommentInfo() {
        System.out.println("/comment/list");
        System.out.println(commentService.getALLComment().toString());
        return commentService.getALLComment();
    }

    /**
     *
     * @return
     */
    @GetMapping("/article/list")
    public List<Blog> listAllArticleInfo() {
        System.out.println("/article/list");
        return blogservice.getALLBlog();
    }

    /**
     *
     * @return
     */
    @GetMapping("/category/list")
    public List<Category> listAllCategoryInfo() {
        System.out.println("/category/list");
        return categoryService.listAllCategory();
    }
    /**
     *分类的博文的显示
     *
     * @return
     */
    @GetMapping("/article/list/sort/{id}")
    public List<Blog> listCategoryInfoByID(@PathVariable String id) {
        System.out.println("categoryId: "+ id);
        List<Blog> blogs = blogservice.getBlogListByCategoryId(id);
        return blogs;
    }

}
