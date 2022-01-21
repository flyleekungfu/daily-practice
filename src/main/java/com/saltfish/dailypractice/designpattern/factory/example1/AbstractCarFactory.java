package com.saltfish.dailypractice.designpattern.factory.example1;

/**
 * 抽象汽车工厂
 *
 * @author saltfish
 * @date 2020/12/17 15:28
 */
public abstract class AbstractCarFactory {
    public abstract <T extends Car> T createCar(Class<T> clazz);
}

