package com.example.demo.dto;

import java.util.Date;

public class Blog {
    private String ID;
    private Date date;
    private String UserName;
    private String Topic;
    private String Tag;
    private String Article;
    private String Views;
    private String Title;
    private String PictureUrl;
    private boolean Top;
    private int categoryId;
    private String categoryName;

    public Blog(String ID, Date date, String userName, String topic, String tag, String article, String views, String title, String pictureUrl, boolean top, int categoryId, String categoryName) {
        this.ID = ID;
        this.date = date;
        UserName = userName;
        Topic = topic;
        Tag = tag;
        Article = article;
        Views = views;
        Title = title;
        PictureUrl = pictureUrl;
        Top = top;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Blog() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getTopic() {
        return Topic;
    }

    public void setTopic(String topic) {
        Topic = topic;
    }

    public String getTag() {
        return Tag;
    }

    public void setTag(String tag) {
        Tag = tag;
    }

    public String getArticle() {
        return Article;
    }

    public void setArticle(String article) {
        Article = article;
    }

    public String getViews() {
        return Views;
    }

    public void setViews(String views) {
        Views = views;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPictureUrl() {
        return PictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        PictureUrl = pictureUrl;
    }

    public boolean isTop() {
        return Top;
    }

    public void setTop(boolean top) {
        Top = top;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "ID=" + ID +
                ", date=" + date +
                ", UserName='" + UserName + '\'' +
                ", Topic='" + Topic + '\'' +
                ", Tag='" + Tag + '\'' +
                ", Article='" + Article + '\'' +
                ", Views='" + Views + '\'' +
                ", Title='" + Title + '\'' +
                ", PictureUrl='" + PictureUrl + '\'' +
                ", Top=" + Top +
                ", categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
