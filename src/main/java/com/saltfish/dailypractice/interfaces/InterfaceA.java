package com.saltfish.dailypractice.interfaces;

/**
 * 接口A
 *
 * @author saltfish
 * @date 2021/7/13 17:59
 */
public interface InterfaceA {

    default void defaultMethod(String s) {
        System.out.println("接口A的default方法");
    }
}
