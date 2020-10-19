package com.example.demo.dto;

import java.util.Date;

public class Comment {
    private String ID;
    private String UserName;
    private String Blog_ID;
    private String Comment;
    private Date Date;
    private String Reply;
    private String Email;

    public void setEmail(String email) {
        Email = email;
    }

    public String getEmail() {
        return Email;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setBlog_ID(String blog_ID) {
        Blog_ID = blog_ID;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public void setReply(String reply) {
        Reply = reply;
    }

    public Comment(String ID, String userName, String blog_ID, String comment, java.util.Date date, String reply, String email) {
        this.ID = ID;
        UserName = userName;
        Blog_ID = blog_ID;
        Comment = comment;
        Date = date;
        Reply = reply;
        Email = email;
    }
    public Comment() {

    }

    public String getID() {
        return ID;
    }

    public String getUserName() {
        return UserName;
    }

    public String getBlog_ID() {
        return Blog_ID;
    }

    public String getComment() {
        return Comment;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public String getReply() {
        return Reply;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "ID='" + ID + '\'' +
                ", UserName='" + UserName + '\'' +
                ", Blog_ID='" + Blog_ID + '\'' +
                ", Comment='" + Comment + '\'' +
                ", Date=" + Date +
                ", Reply='" + Reply + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}
