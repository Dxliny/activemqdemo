package cn.goktech.jms.springtest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppCoumsumer {
    public static void main(String[] args){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("counsumer.xml");
    }
}
