package cn.goktech.topicactivemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class TopicActiveMQProducer {
    private static final String URL = "tcp://127.0.0.1:61616";
    private static final String TOPIC_DESTINATION = "activemq-topic";
    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(Boolean.TRUE,Session.AUTO_ACKNOWLEDGE);
        try{
            Destination destination = session.createTopic(TOPIC_DESTINATION);
            MessageProducer messageProducer = session.createProducer(destination);
            for(int i=0;i<100;i++){
                TextMessage textMessage = session.createTextMessage("test" + i);
                messageProducer.send(textMessage);
                System.out.println("发送消息");
            }
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }finally {
            connection.close();
        }
    }
}
