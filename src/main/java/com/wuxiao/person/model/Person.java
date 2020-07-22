package com.wuxiao.person.model;

import com.wuxiao.person.method.ISay;


public class Person {
    public Person(String id, ISay iSay) {
        this.id = id;
        this.iSay = iSay;
    }

    private String id;

    private ISay iSay;

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", iSay=" + iSay +
                '}';
    }
}
