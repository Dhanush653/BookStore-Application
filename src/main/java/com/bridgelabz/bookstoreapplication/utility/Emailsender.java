package com.bridgelabz.bookstoreapplication.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class Emailsender {
    @Autowired
    JavaMailSender sender;

    public void sendMail(String tomail, String subject, String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("dk652003@gmail.com");
        message.setTo(tomail);
        message.setSubject(subject);
        message.setText(body);

        sender.send(message);

        System.out.println("Mail send Successfully");
    }
}
