package com.gmail.yurakhomenko2020;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        ContainerText container = new ContainerText();
        Class<?> cls = container.getClass();

        if(!cls.isAnnotationPresent(SaveTo.class)) {
            System.out.println("Error!");
            return;
        }

        SaveTo save = cls.getAnnotation(SaveTo.class);
        String path = save.path();
        Method[] methods = cls.getDeclaredMethods();

        for(Method met : methods) {
            if (met.isAnnotationPresent(Saver.class)) {
                met.invoke(container, path);
                break;
            }
        }
    }
}
