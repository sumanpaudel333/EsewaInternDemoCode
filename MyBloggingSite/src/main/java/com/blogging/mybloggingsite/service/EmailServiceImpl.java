package com.blogging.mybloggingsite.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService{
    @Value("${spring.mail.username}")
    private String fromEmail;
    private final JavaMailSender javaMailSender;
    @Override
    public String send(MultipartFile[] files, String to, String cc, String subject, String body) throws MessagingException, IOException {
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom(fromEmail);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.addCc(cc);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(body);
        for (int i=0;i<files.length;i++){
        mimeMessageHelper.addAttachment(files[i].getOriginalFilename(),new ByteArrayResource(files[i].getBytes()));
        }
        javaMailSender.send(mimeMessage);
        return "Mail Send Successfully! Please Check your Mail. Thank you!";
    }

    @Override
    public String sendWithoutAttachement(String to, String cc, String subject, String body) throws MessagingException, IOException {
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper=new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom(fromEmail);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.addCc(cc);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(body);
        javaMailSender.send(mimeMessage);
        return "Mail Send Successfully! Please Check your Mail. Thank you!";
    }
}
