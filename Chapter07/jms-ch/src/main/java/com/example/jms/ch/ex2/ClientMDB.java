/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jms.ch.ex2;

import java.io.Serializable;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSConnectionFactoryDefinition;
import javax.jms.JMSConnectionFactoryDefinitions;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

/**
 *
 * @author abdalla
 */
@JMSDestinationDefinition(
        name = "java:app/jms/myQueue",
        interfaceName = "javax.jms.Queue",
        destinationName = "myQueue"
)
@JMSConnectionFactoryDefinition(
        name = "java:app/jms/MyConnectionFactory"
)
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "java:app/jms/myQueue")
    ,
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class ClientMDB implements MessageListener {

    @Override
    public void onMessage(Message msg) {
        try {
            // cast to object message
            ObjectMessage message = (ObjectMessage) msg;

            
            // cast message content to the appropriate object
            PaymentInfo paymentInfo = (PaymentInfo) message.getObject();

            // read values and process them
            System.out.println("*** New Payment ***");
            System.out.println("Payment ID: " + paymentInfo.getId());
            System.out.println("Payment Amount: " + paymentInfo.getAmount());

        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }

}
