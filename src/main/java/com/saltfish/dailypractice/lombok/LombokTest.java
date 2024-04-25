package com.saltfish.dailypractice.lombok;

public class LombokTest {

    public static void main(String[] args) {
        Dog dog1 = new Dog();
        dog1.setId(1);
        dog1.setName("小狗1");
        dog1.setCry("旺旺");

        Dog dog2 = new Dog();
        dog2.setId(2);
        dog2.setName("小狗2");
        dog2.setCry("旺旺");

        System.out.println(dog1.equals(dog2));
    }
}
