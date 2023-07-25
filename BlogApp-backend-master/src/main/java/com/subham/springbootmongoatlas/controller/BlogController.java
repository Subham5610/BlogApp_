package com.subham.springbootmongoatlas.controller;//package com.subham.springbootmongoatlas.controller;
//
//import com.subham.springbootmongoatlas.model.Blog;
//import com.subham.springbootmongoatlas.service.BlogService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.scheduling.config.Task;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//@CrossOrigin(origins = "http://localhost:3000")
//@RestController
//@RequestMapping("/blogs")
//public class BlogController {
//    @Autowired
//    private BlogService service;
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Blog createBlog(@RequestBody Blog blog){
//        return service.addblog(blog);
//    }
//    @GetMapping
//    public List<Blog> getBlogs(){
//        return service.findallBlogs();
//    }
//    @GetMapping("/{blogId}")
//    public Blog getBlog(@PathVariable String blogId){
//        return service.getBlogByBlogId(blogId);
//    }
//    @GetMapping("/userId/{userId}")
//    public List<Blog> findBlogUsingUserId(@PathVariable String userId){
//        return service.getBlogbyUserId(userId);
//    }
//    @PutMapping
//    public Blog modifyBlog(@RequestBody Blog blog){
//        return service.updateBlog(blog);
//    }
//    @DeleteMapping("/{blogId}")
//    public String deleteBlog(@PathVariable String blogId){
//        return service.deleteBlog(blogId);
//    }
//
//
//
//
//}

import com.subham.springbootmongoatlas.model.Blog;
import com.subham.springbootmongoatlas.service.BlogService;
import com.subham.springbootmongoatlas.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.mail.MessagingException;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private BlogService service;



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Blog> createBlog(@RequestBody Blog blog) {
        return service.addBlog(blog);
    }

    @GetMapping
    public Flux<Blog> getBlogs() {
        return service.findAllBlogs();
    }

    @GetMapping("/{blogId}")
    public Mono<Blog> getBlog(@PathVariable String blogId) {
        return service.getBlogByBlogId(blogId);
    }

    @GetMapping("/userId/{userId}")
    public Flux<Blog> findBlogUsingUserId(@PathVariable String userId) {
        return service.getBlogByUserId(userId);
    }

    @PutMapping
    public Mono<Blog> modifyBlog(@RequestBody Blog blog) {
        return service.updateBlog(blog);
    }

    @DeleteMapping("/{blogId}")
    public Mono<String> deleteBlog(@PathVariable String blogId) {
        return service.deleteBlog(blogId);
    }

}
