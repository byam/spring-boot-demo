package edu.miu.spring.boot.demo.controller;

import edu.miu.spring.boot.demo.domain.User;
import edu.miu.spring.boot.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController{

    private final UserService userService;

    public AdminController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<User> findAll(){
        return userService.findAll();
    }
}
