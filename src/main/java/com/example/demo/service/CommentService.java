package com.example.demo.service;

import com.example.demo.dto.Comment;

import java.util.List;

public interface CommentService {
    public int addComment(Comment comment);
    public int deleteCommentById(Long id);
    public int deleteArticleCommentById(Long id);
    public List<Comment> listAllArticleCommentById(Long id);
    public List<Comment> getALLComment();

}
