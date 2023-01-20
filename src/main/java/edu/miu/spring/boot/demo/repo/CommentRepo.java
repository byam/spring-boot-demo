package edu.miu.spring.boot.demo.repo;

import edu.miu.spring.boot.demo.domain.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepo extends CrudRepository<Comment, Integer> {
}
