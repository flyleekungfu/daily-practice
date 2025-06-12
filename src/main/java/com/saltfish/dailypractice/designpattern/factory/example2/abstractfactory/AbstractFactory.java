package com.saltfish.dailypractice.designpattern.factory.example2.abstractfactory;

public abstract class AbstractFactory {
    public abstract Phone createPhone(String brand) ;

    public abstract Computer createComputer(String brand);
}
