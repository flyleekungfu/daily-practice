package com.saltfish.dailypractice.designpattern.strategy;

/**
 * 加策略
 *
 * @author saltfish
 * @date 2021/7/13 9:36
 */
public class OperationAdd implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
