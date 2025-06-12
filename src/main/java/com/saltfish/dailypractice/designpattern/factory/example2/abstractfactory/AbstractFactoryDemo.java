package com.saltfish.dailypractice.designpattern.factory.example2.abstractfactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AbstractFactoryDemo {

    public static void main(String[] args) {
        AbstractFactory phoneFactory = new PhoneFactory();
        Phone phoneHuawei = phoneFactory.createPhone("Huawei");
        Phone phoneApple = phoneFactory.createPhone("Apple");
        log.info(phoneHuawei.call());
        log.info(phoneApple.call());

        AbstractFactory computerFactory = new ComputerFactory();
        Computer computerHuawei = computerFactory.createComputer("Huawei");
        Computer computerApple = computerFactory.createComputer("Apple");
        log.info(computerHuawei.internet());
        log.info(computerApple.internet());
    }
}
