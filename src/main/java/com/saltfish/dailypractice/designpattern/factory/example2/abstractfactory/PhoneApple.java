package com.saltfish.dailypractice.designpattern.factory.example2.abstractfactory;

public class PhoneApple implements Phone{
    @Override
    public String call() {
        return "call somebody by Apple Phone";
    }
}
