package com.saltfish.dailypractice.designpattern.chain_of_responsibility.logger;

public class DebugBasedLogger extends Logger{

    public DebugBasedLogger(int levels) {
        this.levels = levels;
    }

    @Override
    protected void displayLogInfo(String msg) {
        System.out.println("DEBUG LOGGER INFO: "+msg);
    }
}
