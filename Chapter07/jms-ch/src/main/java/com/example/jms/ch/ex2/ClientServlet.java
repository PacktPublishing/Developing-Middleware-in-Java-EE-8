/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jms.ch.ex2;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.TextMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author abdalla
 */
@WebServlet(urlPatterns = "/test")
public class ClientServlet extends HttpServlet {

    @Inject
    @JMSConnectionFactory("java:app/jms/MyConnectionFactory")
    private JMSContext context;

    @Resource(lookup = "java:app/jms/myQueue")
    private Queue queue;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            //        TextMessage textMessage = context.createTextMessage("some text");
//            // create a map message
//            MapMessage mapMessage = context.createMapMessage();
//            
//            // put values
//            mapMessage.setString("name", "foo");
//            mapMessage.setInt("count", 50);
//

            // create object content
            PaymentInfo paymentInfo = new PaymentInfo();
            paymentInfo.setId(1005);
            paymentInfo.setAmount(new BigDecimal("185.1"));
            
            // create an object message instance, passing it the content
            ObjectMessage objectMessage = context.createObjectMessage();
            objectMessage.setObject(paymentInfo);
            
            // send it
            context.createProducer().send(queue, objectMessage);
        } catch (JMSException ex) {
            Logger.getLogger(ClientServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
