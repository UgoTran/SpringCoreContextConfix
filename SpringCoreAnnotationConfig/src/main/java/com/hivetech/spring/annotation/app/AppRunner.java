package com.hivetech.spring.annotation.app;

import com.hivetech.spring.annotation.context.SpringAnnotationAppContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppRunner {

    public static void main(String[] args) {
        System.out.println("_\t Spring Core Annotation Context");
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(SpringAnnotationAppContext.class);
    }
}
