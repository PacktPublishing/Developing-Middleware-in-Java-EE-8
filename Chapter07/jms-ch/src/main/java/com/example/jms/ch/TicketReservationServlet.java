/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jms.ch;

import java.io.IOException;
import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author abdalla
 */
@WebServlet(urlPatterns = "/tickets/reserve")
public class TicketReservationServlet extends HttpServlet {

    @Resource(lookup = "jms/ticketsReservationFactory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "jms/ticketsReservationTopic")
    private Topic topic;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // create a JMS context object
            JMSContext context = connectionFactory.createContext();
            // create JMS producer object from this context
            JMSProducer producer = context.createProducer();
            // create a JMS text message from this context
            TextMessage textMessage = context.createTextMessage();
            textMessage.setText("First message");
            
            // send the text message
            producer.send(topic, textMessage);
            
            resp.getOutputStream().println("Message sent successfully!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
