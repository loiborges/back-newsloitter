package br.com.loi.newsloitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public String sendEmail(String email, String mensagem, String assunto){
        try {
            MimeMessage mail = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail);

            helper.setTo(email);
            helper.setFrom("newsloitter@gmail.com","NewsLoitter");
            helper.setSubject(assunto);
            helper.setText("<!DOCTYPE html>\n" +
                    "<html lang=\"pt-BR\">\n" +
                    "<head> </head>\n" +
                    "<body>\n" +
                    "<p> "+ mensagem +" </p>" +
                    "</body>\n" +
                    "</html>",true);
            mailSender.send(mail);
            return "OK";
        } catch (Exception e) {
            e.getMessage();
            return e.getMessage();
        }
    }
}
