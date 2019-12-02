package com.hivetech.SpringCore.preConfig.xmlConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppRunner {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:DBxmlConfig.xml");
        DBInfo info = context.getBean(DBInfo.class);
        System.out.println(info);
    }
}
