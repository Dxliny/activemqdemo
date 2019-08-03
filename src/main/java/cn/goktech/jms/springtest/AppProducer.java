package cn.goktech.jms.springtest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppProducer {
    public static void main(String[] args){
        ApplicationContext app = new ClassPathXmlApplicationContext("comment.xml");
        ProducerService2 producerService2 = (ProducerService2) app.getBean("producerService2");
        producerService2.sendMessage("test1");
    }
}
