package com.example.demo.dao;

import com.example.demo.dto.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    int addComment(Comment comment);
    int deleteCommentById(Long id);
    int deleteArticleCommentById(Long id);
    List<Comment> listAllArticleCommentById(Long id);
    List<Comment> getALLComment();
}
