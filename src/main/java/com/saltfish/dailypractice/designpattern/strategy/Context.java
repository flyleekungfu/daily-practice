package com.saltfish.dailypractice.designpattern.strategy;

/**
 * Context类
 *
 * @author saltfish
 * @date 2021/7/13 9:39
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeOperation(int num1, int num2) {
        return strategy.doOperation(num1, num2);
    }
}
