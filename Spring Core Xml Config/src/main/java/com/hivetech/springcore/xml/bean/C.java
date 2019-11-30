package com.hivetech.springcore.xml.bean;

public class C {
    private A instanceA;
    private B instanceB;

    public C() {
        System.out.println("beanC is created: " +hashCode());
    }

    public void setInstanceA(A instanceA) {
        this.instanceA = instanceA;
        System.out.printf("set beanA(%d) to beanC is success%n", instanceA.hashCode());
    }

    public void setInstanceB(B instanceB) {
        this.instanceB = instanceB;
        System.out.printf("set beanB(%d) to beanC is success", instanceB.hashCode());
    }
}
