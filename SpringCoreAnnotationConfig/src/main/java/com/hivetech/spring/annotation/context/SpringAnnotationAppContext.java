package com.hivetech.spring.annotation.context;

import com.hivetech.spring.annotation.bean.A;
import com.hivetech.spring.annotation.bean.B;
import com.hivetech.spring.annotation.bean.C;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringAnnotationAppContext {
    @Bean
    public C createBeanC(){
        return new C();
    }

    @Bean
    public B createBeanB(){
        return new B();
    }

    @Bean
    public A createBeanA(){
        return new A();
    }
}

