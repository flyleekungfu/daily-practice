package com.saltfish.dailypractice.designpattern.strategy;

/**
 * 策略模式demo
 *
 * @author saltfish
 * @date 2021/7/13 9:42
 */
public class StrategyPatternDemo {

    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println(context.executeOperation(2, 1));

        context = new Context(new OperationSubtract());
        System.out.println(context.executeOperation(2, 1));

        context = new Context(new OperationMultiply());
        System.out.println(context.executeOperation(2, 1));
    }
}
