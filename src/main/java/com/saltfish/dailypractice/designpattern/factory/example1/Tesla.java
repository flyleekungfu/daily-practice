package com.saltfish.dailypractice.designpattern.factory.example1;

/**
 * 特斯拉
 *
 * @author saltfish
 * @date 2020/12/17 15:06
 */
public class Tesla implements Car {
    @Override
    public void name() {
        System.out.println("Tesla");
    }

    @Override
    public void drive() {
        System.out.println("Tesla Drive");
    }
}
