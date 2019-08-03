package cn.goktech.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import javax.xml.soap.Text;

public class Getter {
    private static final String URL = "failover:(tcp://127.0.0.1:61616,tcp://127.0.0.1:61617,tcp://127.0.0.1:61618)?randomize=true";
    private static final String DESTINATION = "activemq-one";
    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(DESTINATION);

        MessageConsumer messageConsumer = session.createConsumer(destination);

        messageConsumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage)message;
//                ObjectMessage objectMessage = (ObjectMessage)message;
                try {
                    System.out.println("接受" + textMessage.getText());
//                    System.out.println(objectMessage.getObject().toString());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
//        connection.close();
    }
}
