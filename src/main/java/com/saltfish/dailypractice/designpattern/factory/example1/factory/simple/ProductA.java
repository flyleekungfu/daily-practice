package com.saltfish.dailypractice.designpattern.factory.example1.factory.simple;

/**
 * 产品A
 *
 * @author saltfish
 * @date 2021/8/5 9:41
 */
public class ProductA implements Product{


    @Override
    public void operation1() {
        System.out.println("产品A执行任务1");
    }

    @Override
    public void operation2() {
        System.out.println("产品A执行任务2");
    }
}
