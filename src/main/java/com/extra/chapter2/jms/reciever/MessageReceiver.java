package com.extra.chapter2.jms.reciever;

import org.springframework.jms.annotation.JmsListener;
import com.extra.chapter2.jms.domain.OrderDto;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    @JmsListener(containerFactory = "jmsFactory", destination = "queue-order")
    public void receive(OrderDto order) {
        System.out.println("Received the message: " + order);
    }
}