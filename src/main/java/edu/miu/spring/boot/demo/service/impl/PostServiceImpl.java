package edu.miu.spring.boot.demo.service.impl;

import edu.miu.spring.boot.demo.domain.Post;
import edu.miu.spring.boot.demo.dto.PostDto;
import edu.miu.spring.boot.demo.helper.ListMapper;
import edu.miu.spring.boot.demo.repo.PostRepo;
import edu.miu.spring.boot.demo.service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepo postRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<Post, PostDto> listMapperPostToDto;

    @Override
    public List<PostDto> findAll() {
        return (List<PostDto>) listMapperPostToDto.mapList(postRepo.findAll(), new PostDto());
    }

    @Override
    public PostDto getById(int id) {
        return modelMapper.map(postRepo.getById(id), PostDto.class);
    }

    @Override
    public void save(PostDto postDto) {
        postRepo.save(modelMapper.map(postDto, Post.class));
    }

    @Override
    public void delete(int id) {
        postRepo.delete(id);
    }

    @Override
    public void update(int id, PostDto postDto) {
        postRepo.update(id, modelMapper.map(postDto, Post.class));
    }
}
