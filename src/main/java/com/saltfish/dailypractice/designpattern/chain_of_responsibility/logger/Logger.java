package com.saltfish.dailypractice.designpattern.chain_of_responsibility.logger;

/**
 * 抽象logger
 *
 */
public abstract class Logger {

    public static final int OUTPUTINFO = 1;
    public static final int ERRORINFO = 2;
    public static final int DEBUGINFO = 3;

    protected int levels;

    // 责任链中的下一个元素
    protected Logger nextLevelLogger;

    public void setNextLevelLogger(Logger nextLevelLogger) {
        this.nextLevelLogger = nextLevelLogger;
    }

    public void logMessage(int levels, String msg) {
        if (this.levels <= levels) {
            displayLogInfo(msg);
        }

        if (nextLevelLogger != null) {
            nextLevelLogger.logMessage(levels, msg);
        }
    }

    protected abstract void displayLogInfo(String msg);
}
