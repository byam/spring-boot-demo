package edu.miu.spring.boot.demo.repo;

import edu.miu.spring.boot.demo.entity.Logger;
import org.springframework.data.repository.CrudRepository;

public interface LoggerRepo extends CrudRepository<Logger, Integer> {
}
