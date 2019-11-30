package com.hivetech.spring.annotation.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class A {
    @Autowired
    private B b;

    @Autowired
    public A() {
        System.out.println("Created beanA: " + hashCode());
    }
}
