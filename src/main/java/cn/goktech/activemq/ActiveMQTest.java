package cn.goktech.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ActiveMQTest {
    private static final String URL = "failover:(tcp://127.0.0.1:61617,tcp://127.0.0.1:61618)?randomize=true";
//    private static final String URL = "tcp://127.0.0.1:61617";
    private static final String DESTINATION = "activemq-one";
    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(DESTINATION);
        MessageProducer messageProducer = session.createProducer(destination);
        for(int i=0;i<100;i++){
            TextMessage textMessage = session.createTextMessage("test" + i);
            messageProducer.send(textMessage);
            System.out.println("发送消息");
        }
        session.commit();
        connection.close();
    }
}
