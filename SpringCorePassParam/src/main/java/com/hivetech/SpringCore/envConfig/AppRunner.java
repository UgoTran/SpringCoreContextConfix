package com.hivetech.SpringCore.envConfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppRunner {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringAppEnvContext.class);
        DBInfo info = context.getBean(DBInfo.class);
        System.out.println(info);

    }
}
