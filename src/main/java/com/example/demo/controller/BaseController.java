package com.example.demo.controller;

import com.example.demo.dto.Blog;
import com.example.demo.dto.Category;
import com.example.demo.dto.Comment;
import com.example.demo.dto.User;
import com.example.demo.service.BlogService;
import com.example.demo.service.CategoryService;
import com.example.demo.service.CommentService;
import com.example.demo.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.ByteLookupTable;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class BaseController {
    @Autowired
    SysService sysService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    BlogService blogService;
    @Autowired
    CommentService commentService;


    /**
     * 改变某一篇文章的分类
     *
     * @param id
     * @return
     */
    @PutMapping("article/sort/{id}")
    public String changeArticleCategory(@PathVariable Long id, Long categoryId) {
//        articleService.updateArticleCategory(id, categoryId);
        return null;
    }
    /**
     * 增加一条分类信息数据
     *
     * @return
     */
    @PostMapping("category")
    public int addCategoryInfo(@RequestBody Category categoryInfo) {
        System.out.println("addCategoryInfo");
        categoryInfo.setCreateBy(new Date());
        return categoryService.addCategory(categoryInfo);
    }
    /**
     * 更新/编辑一条分类信息
     *
     * @param id
     * @return
     */
    @PutMapping("category/{id}")
    public String updateCategoryInfo(@PathVariable Long id, @RequestBody Category categoryInfo) {
        categoryService.updateCategory(categoryInfo);
        return null;
    }
    /**
     * 根据ID删除分类信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("category/{id}")
    public String deleteCategoryInfo(@PathVariable Long id) {
        System.out.println("delete category {id}");
        categoryService.deleteCategoryById(id);
        return null;
    }
    /**
     * 通过id获取一条分类信息
     *
     * @param id
     * @return
     */
    @GetMapping("category/{id}")
    public Category getCategoryInfo(@PathVariable Long id) {
        System.out.println("get category/{id}");
        return categoryService.getOneById(id);
    }
    /**
     * 通过id获取一条分类信息
     *
     * @return
     */
//    @GetMapping("sys/view")
//    public List<Blog> listViews() {
//        System.out.println("/sys/view");
//        return blogService.getALLBlog();
//    }


    /**
     * 以下为评论处理功能函数
     */
    /**
     * 通过id获取某一条评论/留言
     *
     * @param id
     * @return
     */
    @GetMapping("comment/{id}")
    public Comment getCommentById(@PathVariable Long id) {
        return null;
    }

    /**
     * 回复留言/评论，通过id去找到对应的Email
     *
     * @param id
     * @return
     */
    @GetMapping("comment/reply/{id}")
    public String replyComment(@PathVariable Long id) {
        return null;
    }
    /**
     * 通过id删除某一条留言
     *
     * @param id
     * @return
     */
    @DeleteMapping("comment/{id}")
    public int deleteComment(@PathVariable Long id) {
        return commentService.deleteCommentById(id);
    }
    /**
     * 通过评论ID删除文章评论信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("comment/article/{id}")
    public int deleteArticleComment(@PathVariable Long id) {
        return commentService.deleteArticleCommentById(id);
    }

    /**
     * 通过ID获取一篇文章，内容为MD源码格式
     *
     * @param id
     * @return
     */
    @GetMapping("article/{id}")
    public Blog getArticleDtoById(@PathVariable String id) {
        return blogService.getBlogByID(id);
    }
    /**
     * 编辑/更新一篇文章
     *
     * @return
     */
    @PutMapping("article/{id}")
    public String updateArticle(@PathVariable Long id, @RequestBody Blog blog) {
        blog.setID(String.valueOf(id));
        Category cat = categoryService.getOneById(Long.valueOf(blog.getCategoryId()));
        blog.setCategoryName(cat.getName());
        Blog tem = blogService.getBlogByID(String.valueOf(id));//获取当前ID 的blog
        /**
         * 此处针对两个分类的
         */
        System.out.println(tem.getCategoryName()+" "+blog.getCategoryName());

        if(!tem.getCategoryName().equals(blog.getCategoryName())){
            Category cat1 = categoryService.getOneById(Long.valueOf(tem.getCategoryId()));
            cat1.setNumber(cat1.getNumber() - 1);
            System.out.println(cat1.toString());
            Category cat2 = categoryService.getOneById(Long.valueOf(blog.getCategoryId()));
            cat2.setNumber(cat2.getNumber() + 1);
            System.out.println(cat2.toString());
            categoryService.updateCategory(cat1);
            categoryService.updateCategory(cat2);
        }
        blogService.updateBlog(blog);
//        System.out.println(articleDto.getTop());
        return null;
    }

    /**
     * 删除一篇文章
     *
     * @param id
     * @return
     */
    @DeleteMapping("article/{id}")
    public int deleteArticle(@PathVariable String id) {
        Blog blog = blogService.getBlogByID(id);
        Category cat = categoryService.getOneById(Long.valueOf(blog.getCategoryId()));
        cat.setNumber(cat.getNumber() - 1);
        categoryService.updateCategory(cat);
        return blogService.deleteBlogById(id);
    }
    /**
     * 增加一篇文章
     *
     * @return
     */
    @PostMapping("article/")
    public int addArticle(@RequestBody Blog blog) {
        System.out.println(blog.toString());
        Category cat = categoryService.listCategoryByID(String.valueOf(blog.getCategoryId())).get(0);
        cat.setNumber(cat.getNumber() + 1);
        categoryService.updateCategory(cat);
        blog.setCategoryName(cat.getName());
        return blogService.addBlog(blog);
    }



    /* 后台登录账号密码 */
    private static String username = "admin";
    private static String password = "123";





}
