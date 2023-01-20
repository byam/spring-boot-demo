package edu.miu.spring.boot.demo.service.impl;

import edu.miu.spring.boot.demo.domain.Comment;
import edu.miu.spring.boot.demo.domain.Post;
import edu.miu.spring.boot.demo.dto.PostDto;
import edu.miu.spring.boot.demo.helper.ListMapper;
import edu.miu.spring.boot.demo.repo.CommentRepo;
import edu.miu.spring.boot.demo.repo.PostRepo;
import edu.miu.spring.boot.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepo postRepo;
    private final CommentRepo commentRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<Post, PostDto> listMapperPostToDto;

    @Override
    public List<PostDto> findAll() {
        List<Post> posts = new ArrayList<>();
        postRepo.findAll().forEach(posts::add);
        return (List<PostDto>) listMapperPostToDto.mapList(posts, new PostDto());
    }

    @Override
    public Post findById(int id) {
        return postRepo.findById(id).orElse(null);
    }

    @Override
    public PostDto getById(int id) {
        return modelMapper.map(postRepo.findById(id), PostDto.class);
    }

    @Override
    public void save(Post post) {
        postRepo.save(post);
    }

    @Override
    public void delete(int id) {
        postRepo.deleteById(id);
    }

    @Override
    public void update(int id, Post post) {
        post.setId(id);
        postRepo.save(post);
    }

    @Override
    public void saveComment(int id, Comment comment) {
        var post = postRepo.findById(id).orElse(null);
        if(post == null) return;

        commentRepo.save(comment);

        var comments = post.getComments();
        comments.add(comment);
        post.setComments(comments);
        postRepo.save(post);
    }
}
