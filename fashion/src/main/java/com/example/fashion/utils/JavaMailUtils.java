package com.example.fashion.utils;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

@Component
public class JavaMailUtils {
    @Autowired
    private JavaMailSender emailSender;
    public void sendSimpleEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("kaukebonatip@outlook.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    public void sendPasswordNew(String to, String username,String passwordReset) throws UnsupportedEncodingException, MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(new InternetAddress("kaukebonatip@outlook.com", "C06 - Fashion"));
        helper.setTo(to);
        helper.setSubject("Khôi phục mật khẩu tài khoản");
        String htmlContent = readHtmlFile("mail-template/template-mail-recover.html");
        htmlContent = htmlContent.replace("[username]", username);
        htmlContent = htmlContent.replace("[Mật Khẩu Tạm]", passwordReset);
        helper.setText(htmlContent,true);
        emailSender.send(message);
    }

    public String readHtmlFile(String filePath) {
        try {
            Resource resource = new ClassPathResource(filePath);
            byte[] encoded = Files.readAllBytes(resource.getFile().toPath());
            return new String(encoded, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
