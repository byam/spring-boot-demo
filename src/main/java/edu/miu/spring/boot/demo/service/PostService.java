package edu.miu.spring.boot.demo.service;

import edu.miu.spring.boot.demo.domain.Post;
import edu.miu.spring.boot.demo.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findAll();

    PostDto getById(int id);

    void save(Post post);

    void delete(int id);

    void update(int id, Post post);
}
