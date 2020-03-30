package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        Resume resume = new Resume();
        Field field = resume.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(resume));
        field.set(resume, "new_uuid");
        System.out.println(resume);

//        Class clazz = Class.forName(Resume.class.getName());
//        Method toString = clazz.getDeclaredMethod("toString");
        Method toString = resume.getClass().getDeclaredMethod("toString");
        System.out.print("invoke method " + toString.getName() + " : " + toString.invoke(resume));
    }
}