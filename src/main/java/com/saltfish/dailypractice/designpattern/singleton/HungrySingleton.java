package com.saltfish.dailypractice.designpattern.singleton;

/**
 * 饿汉单例
 */
public class HungrySingleton {

    // 1.防止外部直接 new 对象破坏单例模式
    private HungrySingleton() {
    }

    // 2.通过私有变量保存单例对象
    private static final HungrySingleton instance = new HungrySingleton();

    // 3.提供公共获取单例对象的方法
    public static HungrySingleton getInstance() {
        return instance;
    }
}
