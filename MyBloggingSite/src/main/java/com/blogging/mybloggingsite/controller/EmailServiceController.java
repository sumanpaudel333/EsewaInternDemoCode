package com.blogging.mybloggingsite.controller;

import com.blogging.mybloggingsite.service.EmailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mail")
public class EmailServiceController {
    private final EmailService emailService;

    @PostMapping("/send")
    public String sendMail(@RequestParam(value = "files",required = false)MultipartFile[] files, String to, String cc,String subject,String body) throws MessagingException, IOException {
         return emailService.send(files,to,cc,subject,body);
    }
}
