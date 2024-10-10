package com.saltfish.dailypractice.reflect;

/**
 * 反射demo
 */
public class ReflectDemo {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        newObject();
        reflectObject();
    }

   public static void newObject() {
       long startTime = System.currentTimeMillis();

       for (int i = 0; i < 100000000; i++) {
           ReflectDemo reflectDemo = new ReflectDemo();
       }

       long endTime = System.currentTimeMillis();
       System.out.println("new耗时为：" + (endTime - startTime));
   }

   public static void reflectObject() throws InstantiationException, IllegalAccessException {
       long startTime = System.currentTimeMillis();
       Class<ReflectDemo> reflectDemoClass = ReflectDemo.class;
       for (int i = 0; i < 100000000; i++) {
           ReflectDemo reflectDemo = reflectDemoClass.newInstance();
       }
       long endTime = System.currentTimeMillis();
       System.out.println("反射耗时：" + (endTime - startTime));
   }
}
