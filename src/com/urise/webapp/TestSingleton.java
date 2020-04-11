package com.urise.webapp;

import com.urise.webapp.model.SectionType;

public class TestSingleton {
    private static TestSingleton instance;

    public static TestSingleton getInstance() {
        if (instance == null) {
            instance = new TestSingleton();
        }
        return instance;
    }

    private TestSingleton() {
    }

    public static void main(String[] args) {
        TestSingleton.getInstance().toString();
        Singleton singleton = Singleton.valueOf("SINGLETON");
        System.out.println(singleton.name());
        System.out.println(singleton.ordinal());
        for(SectionType type: SectionType.values()) {
            System.out.println(type.getTitle());
        }
    }

    public enum Singleton {
        SINGLETON
    }
}
