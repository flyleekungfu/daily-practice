package com.saltfish.dailypractice.designpattern.chain_of_responsibility.logger;


public class ErrorBasedLogger extends Logger{

    public ErrorBasedLogger(int levels) {
        this.levels = levels;
    }

    @Override
    protected void displayLogInfo(String msg) {
        System.out.println("ERROR LOGGER INFO: "+msg);
    }
}
