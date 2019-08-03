package cn.goktech.topicactivemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Getter {
    private static final String URL = "tcp://127.0.0.1:61616";
    private static final String TOPIC_DESTINATION = "activemq-topic";

    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建订阅者
        Destination destination = session.createTopic(TOPIC_DESTINATION);

        MessageConsumer messageConsumer = session.createConsumer(destination);

        messageConsumer.setMessageListener(message -> {
            TextMessage textMessage = (TextMessage) message;
//                ObjectMessage objectMessage = (ObjectMessage)message;
            try {
                System.out.println("接受" + textMessage.getText());
//                    System.out.println(objectMessage.getObject().toString());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        });
//        connection.close();
    }
}
