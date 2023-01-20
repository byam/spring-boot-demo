package edu.miu.spring.boot.demo.controller;

import edu.miu.spring.boot.demo.domain.Comment;
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

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Post> findAll(@RequestParam(value = "title", required = false) String title){
        return title == null ? postService.findAll() : postService.findAllByTitleEquals(title);
    }

    @GetMapping("/dto")
    @ResponseStatus(HttpStatus.OK)
    public List<PostDto> findAllDto(){
        return postService.findAllDto();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post findById(@PathVariable int id){
        return postService.findById(id);
    }

    @GetMapping("/{id}/dto")
    @ResponseStatus(HttpStatus.OK)
    public PostDto findByIdDto(@PathVariable int id){
        return postService.findByIdDto(id);
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

    @GetMapping("/{id}/comments")
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> findAllComment(@PathVariable int id){
        var post = postService.findById(id);
        if(post == null) return null;
        return postService.findById(id).getComments();
    }

    @PostMapping("/{id}/comments")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveComment(@PathVariable int id, @RequestBody Comment comment){
        postService.saveComment(id, comment);
    }
}
