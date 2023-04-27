package com.saltfish.dailypractice.designpattern.chain_of_responsibility.logger;

public class ConsoleBasedLogger extends Logger {

    public ConsoleBasedLogger(int levels) {
        this.levels = levels;
    }

    @Override
    protected void displayLogInfo(String msg) {
        System.out.println("CONSOLE LOGGER INFO: "+msg);
    }
}
