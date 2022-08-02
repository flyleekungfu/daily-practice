package com.saltfish.dailypractice.designpattern.singleton;

public class StaticSingleton {

    // 1.防止外部直接 new 对象破坏单例模式
    private StaticSingleton() {
    }

    // 2.静态内部类
    private static class SingletonHolder{
        private static final StaticSingleton INSTANCE = new StaticSingleton();
    }

    // 3.提供公共获取单例对象的方法
    public static StaticSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
