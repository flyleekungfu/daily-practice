package com.saltfish.dailypractice.designpattern.strategy;

/**
 * 策略
 *
 * 参考链接：https://www.runoob.com/design-pattern/strategy-pattern.html
 * @author saltfish
 * @date 2021/7/13 9:32
 */
public interface Strategy {

    /**
     * 操作
     * @param num1 数字1
     * @param num2 数字2
     */
    int doOperation(int num1, int num2);
}
