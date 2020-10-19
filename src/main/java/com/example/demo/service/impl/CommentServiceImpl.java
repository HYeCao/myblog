package com.example.demo.service.impl;


import com.example.demo.dao.CommentMapper;
import com.example.demo.dto.Comment;
import com.example.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired(required = false)
    CommentMapper comMapper;
    @Override
    public int addComment(Comment comment) {
        return comMapper.addComment(comment);
    }

    @Override
    public int deleteCommentById(Long id) {
        return comMapper.deleteCommentById(id);
    }

    @Override
    public int deleteArticleCommentById(Long id) {
        return comMapper.deleteArticleCommentById(id);
    }

    @Override
    public List<Comment> listAllArticleCommentById(Long id) {

        return comMapper.listAllArticleCommentById(id);
    }

    @Override
    public List<Comment> getALLComment() {
        return comMapper.getALLComment();
    }
}
