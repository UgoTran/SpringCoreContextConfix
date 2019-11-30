package com.hivetech.sping.mix.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class A {
    private B instantB;
    private C instantC;

    public A() {
        System.out.println("Creating bean A " + this);
    }

    @Autowired
    public void setInstantB(B instantB) {
        System.out.println("Setting A.instantB with " + instantB);
        this.instantB = instantB;
    }

    @Autowired
    public void setInstantC(C instantC) {
        System.out.println("Setting A.instantC with " + instantC);
        this.instantC = instantC;
    }
}
