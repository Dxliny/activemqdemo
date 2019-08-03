package cn.goktech.jms.producer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppCounsumer {
    public static void main(String[] args){
        ApplicationContext app = new ClassPathXmlApplicationContext("producer.xml");
    }
}
