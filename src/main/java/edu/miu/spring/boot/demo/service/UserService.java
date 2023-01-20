package edu.miu.spring.boot.demo.service;

import edu.miu.spring.boot.demo.domain.User;
import edu.miu.spring.boot.demo.dto.UserDto;

import java.util.List;

public interface UserService {
    List<User> findAll();

    List<UserDto> findAllDto();

    User findById(int id);

    UserDto findByIdDto(int id);

    void save(User user);

    void deleteById(int id);

    void update(int id, User user);

    List<User> findAllPostsGreaterThan(int postNum);
}
