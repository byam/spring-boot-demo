package edu.miu.spring.boot.demo.controller;

import edu.miu.spring.boot.demo.domain.Post;
import edu.miu.spring.boot.demo.dto.PostDto;
import edu.miu.spring.boot.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PostDto> getAll(){
        return postService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PostDto getById(@PathVariable int id){
        return postService.getById(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Post post){
        postService.save(post);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id){
        postService.delete(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable int id, @RequestBody Post post){
        postService.update(id, post);
    }
}
