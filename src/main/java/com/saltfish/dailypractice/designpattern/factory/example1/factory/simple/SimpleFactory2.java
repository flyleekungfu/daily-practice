package com.saltfish.dailypractice.designpattern.factory.example1.factory.simple;

/**
 * 简单工厂2（使用反射）
 *
 * @author saltfish
 * @date 2021/8/5 9:57
 */
public class SimpleFactory2 {

    /**
     * 反射机制获取实体类
     *
     * @param clazz 类
     * @return T
     * @author saltfish
     * @date 2021/8/5 10:00
     */
    @SuppressWarnings("unchecked")
    public <T> T createByClazzName(Class<? extends T> clazz) {
        T obj = null;
        try {
            obj = (T)Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
