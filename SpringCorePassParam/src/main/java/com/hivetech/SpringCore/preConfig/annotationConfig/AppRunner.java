package com.hivetech.SpringCore.preConfig.annotationConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppRunner {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringAppContext.class);
        DBInfo info = context.getBean(DBInfo.class);
        System.out.println(info);
    }
}
