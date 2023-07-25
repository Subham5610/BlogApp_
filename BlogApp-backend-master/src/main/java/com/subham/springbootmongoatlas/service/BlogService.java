package com.subham.springbootmongoatlas.service;//package com.subham.springbootmongoatlas.service;

import com.subham.springbootmongoatlas.model.Blog;
import com.subham.springbootmongoatlas.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

//@Service
//public class BlogService {
//
//    @Autowired
//    private BlogRepository repository;
//   //create
//    public Blog addblog(Blog blog){
//        blog.setBlogId(UUID.randomUUID().toString().split("-")[0]);
//        return repository.save(blog);
//    }
//    //read
//    public List<Blog>findallBlogs(){
//        return repository.findAll();
//    }
//    public Blog getBlogByBlogId(String blogId){
//        return repository.findById(blogId).get();
//    }
//
//    public List<Blog> getBlogbyUserId(String userId){
//        return repository.findByUserId(userId);
//    }
//
//    //update
//
//    public Blog updateBlog(Blog blogRequest){
//        Blog existingBlog = repository.findById(blogRequest.getBlogId()).get();
//        existingBlog.setTitle(blogRequest.getTitle());
//        existingBlog.setContent(blogRequest.getContent());
//        return repository.save(existingBlog);
//
//    }
//
//    //delete
//
//    public String deleteBlog(String blogId){
//        repository.deleteById(blogId);
//        return blogId + "blog deleted";
//    }
//}
@Service
public class BlogService {
    private final BlogRepository repository;
    private final EmailService emailService;
    @Autowired
    public BlogService(BlogRepository repository, EmailService emailService) {
        this.repository = repository;
        this.emailService = emailService;
    }
    public Mono<Blog> addBlog(Blog blog) {
        blog.setBlogId(UUID.randomUUID().toString().split("-")[0]);
        sendEmailAlert(blog);
        return repository.save(blog);
    }
    public Flux<Blog> findAllBlogs() {
        return repository.findAll();
    }
    public Mono<Blog> getBlogByBlogId(String blogId) {
        return repository.findById(blogId);
    }
    public Flux<Blog> getBlogByUserId(String userId) {
        return repository.findByUserId(userId);
    }
    public Mono<Blog> updateBlog(Blog blogRequest) {
        return repository.findById(blogRequest.getBlogId())
                .flatMap(existingBlog -> {
                    existingBlog.setContent(blogRequest.getContent());
                    existingBlog.setTitle(blogRequest.getTitle());
                    return repository.save(existingBlog);
                });
    }
    public Mono<String> deleteBlog(String blogId) {
        return repository.deleteById(blogId)
                .then(Mono.just(blogId + " blog is deleted from dashboard..."));
    }
    private void sendEmailAlert(Blog blog)
    {
        String recipientEmail = blog.getEmail(); // Get the recipient's email from the blog
        String subject = "New Blog Post Alert";
        String content = "A new blog post titled \"" + blog.getTitle() + "\" has been posted.";
        emailService.sendEmail(recipientEmail, subject, content).subscribe(); // Send the email asynchronously
    }
}






