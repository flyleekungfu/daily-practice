package com.saltfish.dailypractice.designpattern.factory.example1;

/**
 * 奔驰
 *
 * @author saltfish
 * @date 2020/12/17 15:07
 */
public class Benz implements Car {
    @Override
    public void name() {
        System.out.println("Benz");
    }

    @Override
    public void drive() {
        System.out.println("Benz drive");
    }
}
