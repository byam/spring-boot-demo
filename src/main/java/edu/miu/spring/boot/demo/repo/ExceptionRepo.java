package edu.miu.spring.boot.demo.repo;

import edu.miu.spring.boot.demo.entity.Exception;
import org.springframework.data.repository.CrudRepository;

public interface ExceptionRepo extends CrudRepository<Exception, Integer> {
}
