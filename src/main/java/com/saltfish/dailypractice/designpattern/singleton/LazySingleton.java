package com.saltfish.dailypractice.designpattern.singleton;

public class LazySingleton {
    // 1.防止外部直接 new 对象破坏单例模式
    private LazySingleton() {
    }

    // 2.通过私有变量保存单例对象
    private static volatile LazySingleton instance = null;

    // 3.提供公共获取单例对象的方法
    public static LazySingleton getInstance() {
        if (instance == null) {
            // 第一次效验
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    // 第二次效验
                    instance = new LazySingleton();
                }
            }
        }

        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance());
    }
}
