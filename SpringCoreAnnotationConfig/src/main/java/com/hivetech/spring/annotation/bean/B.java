package com.hivetech.spring.annotation.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class B {
    private C c;

    public B() {
        System.out.println("Created beanB " + hashCode());
    }

    @Autowired
    public void setC(C c) {
        this.c = c;
    }
}
