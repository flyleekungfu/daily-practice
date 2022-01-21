package com.saltfish.dailypractice.designpattern.factory.example1.factory.simple;

import cn.hutool.core.util.StrUtil;

/**
 * 简单工厂
 *
 * @author saltfish
 * @date 2021/8/5 9:49
 */
public class SimpleFactory1 {

    public Product create(String productType) {
        if (StrUtil.isBlank(productType)) {
            return null;
        }

        if ("productA".equals(productType)) {
            return new ProductA();
        } else if ("productB".equals(productType)) {
            return new ProductB();
        }

        return null;
    }
}
