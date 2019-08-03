package cn.goktech.jms.producer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppProducer {
    public static void main(String[] args){
        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:producer.xml");
        ProducerService producerService = (ProducerService) app.getBean("producerService");
        for(int i=0;i<100;i++){
            producerService.sendMessage("hello" + i);
        }
    }
}
