package com.subham.springbootmongoatlas.service;

import com.subham.springbootmongoatlas.model.Blog;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.mail.MessagingException;

@Service
public class EmailService {
    private final JavaMailSender mailSender;
    @Autowired
    public EmailService(JavaMailSender mailSender){
        this.mailSender=mailSender;
    }

    public Mono<Void>sendEmail(String recipientEmail, String subject, String content){
        return Mono.fromRunnable(()->
        {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("subhamrcf@gmail.com");
            message.setTo(recipientEmail);
            message.setSubject(subject);
            message.setText(content);
            mailSender.send(message);
        });
    }
}