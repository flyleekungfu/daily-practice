package com.saltfish.dailypractice.designpattern.factory.example2.abstractfactory;

public class PhoneHuawei implements Phone{
    @Override
    public String call() {
        return "call somebody by Huawei Phone";
    }
}
