package com.saltfish.dailypractice.designpattern.factory.example2.abstractfactory;

public class PhoneFactory extends AbstractFactory{

    @Override
    public Phone createPhone(String brand) {
        if ("Huawei".equals(brand)) {
            return new PhoneHuawei();
        } else if ("Apple".equals(brand)) {
            return new PhoneApple();
        } else {
            return null;
        }
    }

    @Override
    public Computer createComputer(String brand) {
        return null;
    }
}
