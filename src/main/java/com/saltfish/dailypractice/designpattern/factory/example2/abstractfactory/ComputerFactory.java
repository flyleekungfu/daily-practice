package com.saltfish.dailypractice.designpattern.factory.example2.abstractfactory;

public class ComputerFactory extends AbstractFactory{

    @Override
    public Computer createComputer(String brand) {
        if ("Huawei".equals(brand)) {
            return new ComputerHuawei();
        } else if ("Apple".equals(brand)) {
            return new ComputerApple();
        } else {
            return null;
        }
    }

    @Override
    public Phone createPhone(String brand) {
        return null;
    }
}
