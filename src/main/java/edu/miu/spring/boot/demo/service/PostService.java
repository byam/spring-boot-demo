package edu.miu.spring.boot.demo.service;

import edu.miu.spring.boot.demo.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findAll();

    PostDto getById(int id);

    void save(PostDto postDto);

    void delete(int id);

    void update(int id, PostDto postDto);
}
