package edu.miu.spring.boot.demo.repo;

import edu.miu.spring.boot.demo.domain.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepo extends CrudRepository<Post, Integer> {
    List<Post> findAllByTitleEquals(String title);
}
