package edu.miu.spring.boot.demo.repo;

import edu.miu.spring.boot.demo.domain.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepo extends CrudRepository<Post, Integer> {
}
