package edu.miu.spring.boot.demo.service.impl;

import edu.miu.spring.boot.demo.domain.User;
import edu.miu.spring.boot.demo.dto.UserDto;
import edu.miu.spring.boot.demo.helper.ListMapper;
import edu.miu.spring.boot.demo.repo.UserRepo;
import edu.miu.spring.boot.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<User, UserDto> listMapperUserDto;

    @Override
    public List<UserDto> findAll() {
        return (List<UserDto>) listMapperUserDto.mapList( (List<User>)userRepo.findAll(), new UserDto());
    }

    @Override
    public User findById(int id) {
        return userRepo.findById(id).orElseGet(null);
    }

    @Override
    public UserDto findByIdDto(int id) {
        return modelMapper.map(userRepo.findById(id).orElseGet(null), UserDto.class);
    }

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public void deleteById(int id) {
        userRepo.deleteById(id);
    }

    @Override
    public void update(int id, User user) {
        user.setId(id);
        userRepo.save(user);
    }
}
