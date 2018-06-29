/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.io.IOException;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author abdalla
 */
@WebServlet(urlPatterns = "/test2")
public class TestServlet2 extends HttpServlet {

    public TestServlet2() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // to 
        String to = "la3toot@gmail.com";

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
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject("Mail Subject");

            // creeate a multipart content object
            Multipart multipart = new MimeMultipart();
            
            // create a message part for mail body
            BodyPart messageBodyPart = new MimeBodyPart();

            // set the message body in this part
            messageBodyPart.setText("This is message body");

            // add the part to the content
            multipart.addBodyPart(messageBodyPart);

            // create another part for the mail attachment
            messageBodyPart = new MimeBodyPart();
            
            // add the file to this part
            String filename = "/home/abdalla/Desktop/DSC_3234.jpg";
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName("image.jpg");
            multipart.addBodyPart(messageBodyPart);

            // set the message content to all the parts
            message.setContent(multipart);

            // sending the mail
            Transport.send(message);

            System.out.println("Sent message successfully!");

        } catch (MessagingException e) {
            System.out.println("Error sending mail!");
            e.printStackTrace();
        }
    }

}
