package com.saltfish.dailypractice.designpattern.factory.example2;


public class PhoneFactory {

    public static Phone createPhone(String brand) {
        if ("Huawei".equals(brand)) {
            return new PhoneHuawei();
        } else if ("Apple".equals(brand)) {
            return new PhoneApple();
        } else {
            return null;
        }
    }
}
