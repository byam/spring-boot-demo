package edu.miu.spring.boot.demo.service;

import edu.miu.spring.boot.demo.domain.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> findAll();
    Comment findById(int id);
    void save(Comment comment);
    void deleteById(int id);
    void update(int id, Comment comment);
}
