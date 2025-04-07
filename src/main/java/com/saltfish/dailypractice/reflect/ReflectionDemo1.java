package com.saltfish.dailypractice.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        // 1、动态加载类
        Class<?> clazz = Class.forName("com.saltfish.dailypractice.reflect.User");

        // 2、创建对象（无参构建）
        Object obj = clazz.getDeclaredConstructor().newInstance();

        // 3、修改私有字段
        Field nameField = clazz.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(obj, "saltfish");

        // 4、调用私有方法
        Method helloMethod = clazz.getDeclaredMethod("hello");
        helloMethod.setAccessible(true);
        String result = (String) helloMethod.invoke(obj);
        System.out.println(result);
    }
}
