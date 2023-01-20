package edu.miu.spring.boot.demo.controller;

import edu.miu.spring.boot.demo.domain.Comment;
import edu.miu.spring.boot.demo.domain.Post;
import edu.miu.spring.boot.demo.domain.User;
import edu.miu.spring.boot.demo.dto.UserDto;
import edu.miu.spring.boot.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController{

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<User> findAll(@RequestParam(value = "postTitle", required = false) String postTitle){
        return postTitle == null ? userService.findAll() : userService.findAllPostTitleEquals(postTitle);
    }

    @RequestMapping("/postNum")
    @ResponseStatus(HttpStatus.OK)
    public List<User> findAllPostNum(@RequestParam(value = "postsGreaterThan", required = false) Integer postNum){
        return postNum == null ? userService.findAll() : userService.findAllPostsGreaterThan(postNum);
    }

    @RequestMapping("dto")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> findAllDto(){
        return userService.findAllDto();
    }

    @RequestMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User findById(@PathVariable int id){
        return userService.findById(id);
    }

    @RequestMapping("/{id}/dto")
    @ResponseStatus(HttpStatus.OK)
    public UserDto findByIdDto(@PathVariable int id){
        return userService.findByIdDto(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody User user){
        userService.save(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable int id){
        userService.deleteById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable int id, @RequestBody User user){
        userService.update(id, user);
    }

    @RequestMapping("/{id}/posts")
    @ResponseStatus(HttpStatus.OK)
    public List<Post> postsFindById(@PathVariable int id){
        return userService.findById(id).getPosts();
    }

    @RequestMapping("/{id}/posts/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public Post postFindByIdAndPostId(@PathVariable int id, @PathVariable int postId){
        List<Post> posts = userService.findById(id).getPosts();
        return posts.stream().filter(p -> p.getId() == postId).findFirst().orElse(null);
    }

    @RequestMapping("/{id}/posts/{postId}/comments")
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> commentsFindByIdAndPostId(@PathVariable int id, @PathVariable int postId){
        List<Post> posts = userService.findById(id).getPosts();
        Post post = posts.stream().filter(p -> p.getId() == postId).findFirst().orElse(null);
        return post != null ? post.getComments() : null;
    }

    // TODO: FIXME use entity manager and criteria query
    @RequestMapping("/{id}/posts/{postId}/comments/{commentId}")
    @ResponseStatus(HttpStatus.OK)
    public Comment commentFindByIdAndPostIdAndCommentId(@PathVariable int id, @PathVariable int postId, @PathVariable int commentId){
        List<Post> posts = userService.findById(id).getPosts();
        Post post = posts.stream().filter(p -> p.getId() == postId).findFirst().orElse(null);
        if (post == null) return null;

        List<Comment> comments = post.getComments();

        return comments.stream().filter(c -> c.getId() == commentId).findFirst().orElse(null);
    }
}

