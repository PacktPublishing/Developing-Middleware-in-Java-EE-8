/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author abdalla
 */
@WebServlet(urlPatterns = "/test3")
public class TestServlet3 extends HttpServlet {

    public TestServlet3() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // to 
        String from = "abdalla.test.mail@gmail.com";
        final String username = "abdalla.test.mail@gmail.com";
        final String password = "A$dala1988";

        String host = "smtp.gmail.com";

        // mail properties object
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        // creating a mail session
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // creating a message object
            Message message = new MimeMessage(session);

            // filling mail attributes
            message.setFrom(new InternetAddress(from));

            String[] arrTo = {};
            String[] arrCC = {};
            String[] arrBCC = {};
            
            // setting to
            for (String to : arrTo) {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            }
            
            // setting cc
            for (String cc : arrCC) {
                message.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
            }
            
            // setting bbc
            for (String bcc : arrBCC) {
                message.addRecipient(Message.RecipientType.BCC, new InternetAddress(bcc));
            }

            message.setSubject("Mail Subject");
            message.setContent("<html>Hello <b>World</b></html>", "text/html; charset=utf-8");
            //sending the mail
            Transport.send(message);

            System.out.println("Sent message successfully!");

        } catch (MessagingException e) {
            System.out.println("Error sending mail!");
            e.printStackTrace();
        }
    }

}
