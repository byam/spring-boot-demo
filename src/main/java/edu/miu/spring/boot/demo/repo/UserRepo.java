package edu.miu.spring.boot.demo.repo;

import edu.miu.spring.boot.demo.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {
}
