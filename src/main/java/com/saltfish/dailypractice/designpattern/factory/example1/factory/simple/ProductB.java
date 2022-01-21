package com.saltfish.dailypractice.designpattern.factory.example1.factory.simple;

/**
 * 产品B
 *
 * @author saltfish
 * @date 2021/8/5 9:46
 */
public class ProductB implements Product {

    @Override
    public void operation1() {
        System.out.println("产品B执行任务1");
    }

    @Override
    public void operation2() {
        System.out.println("产品B执行任务2");
    }
}
