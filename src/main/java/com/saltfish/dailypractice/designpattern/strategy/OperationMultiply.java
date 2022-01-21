package com.saltfish.dailypractice.designpattern.strategy;

/**
 * 乘操作
 *
 * @author saltfish
 * @date 2021/7/13 9:39
 */
public class OperationMultiply implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
