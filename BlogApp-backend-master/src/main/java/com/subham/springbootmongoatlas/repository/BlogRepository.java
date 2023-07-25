package com.subham.springbootmongoatlas.repository;

import com.subham.springbootmongoatlas.model.Blog;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

//package com.subham.springbootmongoatlas.repository;
//import com.subham.springbootmongoatlas.model.Blog;
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.mongodb.repository.Query;
//
//import java.util.List;
//
//public interface BlogRepository extends MongoRepository<Blog,String> {
//    @Query("{userId : ?0}")
//    List<Blog> findByUserId(String userId);
//}
public interface BlogRepository extends ReactiveMongoRepository<Blog,String> {
    @Query("{userId: ?0}")
    Flux<Blog> findByUserId(String userId);
}



