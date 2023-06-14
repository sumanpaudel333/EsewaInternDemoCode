package com.blogging.mybloggingsite.service;

import jakarta.mail.MessagingException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface EmailService {
    String send(MultipartFile[] files, String to, String cc, String subject,String body) throws MessagingException, IOException;
    String sendWithoutAttachement(String to, String cc, String subject,String body) throws MessagingException, IOException;
}
