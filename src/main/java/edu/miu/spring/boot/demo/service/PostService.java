package edu.miu.spring.boot.demo.service;

import edu.miu.spring.boot.demo.domain.Comment;
import edu.miu.spring.boot.demo.domain.Post;
import edu.miu.spring.boot.demo.dto.PostDto;

import java.util.List;

public interface PostService {
    List<Post> findAll();

    List<Post> findAllByTitleEquals(String title);

    List<PostDto> findAllDto();

    Post findById(int id);

    PostDto findByIdDto(int id);

    void save(Post post);

    void delete(int id);

    void update(int id, Post post);

    void saveComment(int id, Comment comment);
}
