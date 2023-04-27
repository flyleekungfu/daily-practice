package com.saltfish.dailypractice.designpattern.chain_of_responsibility.pass;

public abstract class AbstractHandler {

    /**
     * 下一关用当前抽象类来接收
     */
    protected AbstractHandler next;

    public void setNext(AbstractHandler next) {
        this.next = next;
    }

    public abstract int handler();
}
