package edu.miu.spring.boot.demo.service.impl;

import edu.miu.spring.boot.demo.domain.Post;
import edu.miu.spring.boot.demo.domain.User;
import edu.miu.spring.boot.demo.dto.UserDto;
import edu.miu.spring.boot.demo.helper.ListMapper;
import edu.miu.spring.boot.demo.repo.UserRepo;
import edu.miu.spring.boot.demo.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<User, UserDto> listMapperUserDto;

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        userRepo.findAll().forEach(users::add);
        return users;
    }

    @Override
    public List<UserDto> findAllDto() {
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

    @Override
    public List<User> findAllPostsGreaterThan(int postNum) {
        return userRepo.findUsersWithPosts(postNum);
    }

    @Override
    public List<User> findAllPostTitleEquals(String postTitle) {
        // setting table
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> user = cq.from(User.class);
        Join<User, Post> post = user.join("posts");
        cq.select(user).distinct(true);

        // setting conditions
        Predicate titlePredicate = cb.like(post.get("title"), '%' + postTitle + '%');
        cq.where(titlePredicate);

        // executing queries
        TypedQuery<User> query = entityManager.createQuery(cq);
        return query.getResultList();
    }
}
