package edu.miu.spring.boot.demo.repo.impl;

import edu.miu.spring.boot.demo.domain.Post;
import edu.miu.spring.boot.demo.repo.PostRepo;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepoImpl implements PostRepo {
    private static final List<Post> posts;

    static {
        posts = new ArrayList<>();
        posts.add(new Post(1, "title1", "content1", "author1", LocalDateTime.now()));
        posts.add(new Post(2, "title2", "content2", "author2", LocalDateTime.now()));
        posts.add(new Post(3, "title3", "content3", "author3", LocalDateTime.now()));
    }
    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Post getById(int id) {
        return posts.stream()
                .filter(p -> p.getId() == id)
                .findFirst().orElse(null);
    }

    @Override
    public void save(Post post) {
        post.setId(posts.size() + 1);
        post.setCreatedAt(LocalDateTime.now());
        posts.add(post);
    }

    @Override
    public void delete(int id) {
        var postOptional = posts.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
        postOptional.ifPresent(posts::remove);
    }

    @Override
    public void update(int id, Post updatedPost) {
        var post = getById(id);
        post.setTitle(updatedPost.getTitle());
        post.setContent(updatedPost.getContent());
        post.setAuthor(updatedPost.getAuthor());
    }
}
