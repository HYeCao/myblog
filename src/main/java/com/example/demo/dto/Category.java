package com.example.demo.dto;

import java.util.Date;

/**
 * 文章分类传输对象
 * 说明：关联了tbl_article_category和tbl_category_info两张表的数据
 *
 * @author:wmyskxz
 * @create:2018-06-20-上午 8:45
 */
public class Category {
    //  tbl_article_category表基础字段
    private int categoryId;     // ID
    // tbl_category_info表基础字段
    private String name;        // 分类信息显示名称
    private int number;        // 该分类下对应的文章数量
    private Date createBy;
    private Date modifiedBy;

    public Category(int categoryId, String name, int number, Date createBy, Date modifiedBy) {
        this.categoryId = categoryId;
        this.name = name;
        this.number = number;
        this.createBy = createBy;
        this.modifiedBy = modifiedBy;
    }

    public Category() {
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Date createBy) {
        this.createBy = createBy;
    }

    public Date getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Date modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", createBy=" + createBy +
                ", modifiedBy=" + modifiedBy +
                '}';
    }
}
