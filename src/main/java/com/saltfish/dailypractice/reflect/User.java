package com.saltfish.dailypractice.reflect;


public class User {
    private String name;

    private String hello() {
        return "hello, " + this.name;
    }
}
