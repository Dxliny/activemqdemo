package cn.goktech.jms.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.annotation.Resource;
import javax.jms.*;

public class ProducerServiceImpl implements ProducerService{

    @Autowired
    private JmsTemplate jmsTemplate;

    @Resource(name = "activeMQTopic")
    private Destination destination;

    @Override
    public void sendMessage(final String message) {
        jmsTemplate.send(destination,session -> {
            TextMessage textMessage = session.createTextMessage(message);
            System.out.println("发送消息" + textMessage.getText());
            return textMessage;
        });
    }
}
