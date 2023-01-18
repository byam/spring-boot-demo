package edu.miu.spring.boot.demo.repo;

import edu.miu.spring.boot.demo.domain.Post;

import java.util.List;

public interface PostRepo {
    List<Post> findAll();

    Post getById(int id);

    void save(Post post);

    void delete(int id);

    void update(int id, Post map);
}
