package com.saltfish.dailypractice.designpattern.factory.example1.factory.simple;

/**
 * 简单工厂demo
 *
 * @author saltfish
 * @date 2021/8/5 9:54
 */
public class SimpleFactoryDemo {

    public static void main(String[] args) {
        SimpleFactory1 simpleFactory1 = new SimpleFactory1();

        Product productA1 = simpleFactory1.create("productA");
        productA1.operation1();
        productA1.operation2();

        Product productB1 = simpleFactory1.create("productB");
        productB1.operation1();
        productB1.operation2();

        SimpleFactory2 simpleFactory2 = new SimpleFactory2();

        ProductA productA2 = simpleFactory2.createByClazzName(ProductA.class);
        productA2.operation1();
        productA2.operation2();

        ProductB productB2 = simpleFactory2.createByClazzName(ProductB.class);
        productB2.operation1();
        productB2.operation2();

    }
}
