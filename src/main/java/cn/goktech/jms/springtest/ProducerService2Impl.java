package cn.goktech.jms.springtest;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.TextMessage;

public class ProducerService2Impl implements ProducerService2{

    @Autowired
    private JmsTemplate jmsTemplate;

    @Resource(name = "activeMQQueue")
    private Destination destination;

    @Override
    public void sendMessage(final String message) {
        jmsTemplate.send(destination,session -> {
            TextMessage textMessage = session.createTextMessage(message);
            System.out.println(textMessage.getText() + "消息");
            return textMessage;
        });
    }
}
