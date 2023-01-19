package edu.miu.spring.boot.demo.controller;

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

    @RequestMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> findAll(){
        return userService.findAll();
    }

    @RequestMapping("/{id}")
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
    public List<Post> potsFindById(@PathVariable int id){
        return userService.findById(id).getPosts();
    }
}
