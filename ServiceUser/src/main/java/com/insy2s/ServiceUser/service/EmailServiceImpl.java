package com.insy2s.ServiceUser.service;

import jakarta.mail.internet.InternetHeaders;
import jakarta.mail.internet.MimeBodyPart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.naming.LinkRef;
import java.nio.file.LinkOption;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    // Method 1
    // To send a simple email
    public String sendSimpleMail(String token,String username)
    {

        // Try block to check for exceptions
        try {

            // Creating a simple mail message
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(username);
            InternetHeaders headers = new InternetHeaders();
            headers.addHeader("Content-type", "text/html; charset=UTF-8");
            String html =  "\n<a href='`$token`'>Token</a>";
        mailMessage.setText("To confirm your account, please click here :"+html);
            mailMessage.setSubject("Token to continue registering your account");

            // Sending the mail
            javaMailSender.send(mailMessage);
            return "Mail Sent  Successfully to "+username+"...";
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }

    // Method 2
    // To send an email with attachment

}
