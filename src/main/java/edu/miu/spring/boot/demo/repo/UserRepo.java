package edu.miu.spring.boot.demo.repo;

import edu.miu.spring.boot.demo.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Integer> {

    // #TODO FIXME
//    @Query("select u from User u where u.posts.size >= :num")
    @Query("select u from User u where u.id >= :num")
    List<User> findUsersWithPosts(int num);

    // #TODO FIXME
    @Query("select u from User u")
    List<User> findAllByPostsContainingTitle(String postTitle);
}
