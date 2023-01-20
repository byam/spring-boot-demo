package edu.miu.spring.boot.demo.service.impl;

import edu.miu.spring.boot.demo.domain.Comment;
import edu.miu.spring.boot.demo.repo.CommentRepo;
import edu.miu.spring.boot.demo.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepo commentRepo;

    @Override
    public List<Comment> findAll() {
        List<Comment> comments = new ArrayList<>();
        commentRepo.findAll().forEach(comments::add);
        return comments;
    }

    @Override
    public Comment findById(int id) {
        return commentRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Comment comment) {
        commentRepo.save(comment);
    }

    @Override
    public void deleteById(int id) {
        commentRepo.deleteById(id);
    }

    @Override
    public void update(int id, Comment comment) {
        comment.setId(id);
        commentRepo.save(comment);
    }
}
