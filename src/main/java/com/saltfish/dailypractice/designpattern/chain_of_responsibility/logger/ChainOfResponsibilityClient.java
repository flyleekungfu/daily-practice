package com.saltfish.dailypractice.designpattern.chain_of_responsibility.logger;


public class ChainOfResponsibilityClient {

    public static void main(String[] args) {
        Logger chainLogger = doChaining();

        chainLogger.logMessage(Logger.OUTPUTINFO,  "Enter the sequence of values ");
        chainLogger.logMessage(Logger.ERRORINFO, "An error is occured now");
        chainLogger.logMessage(Logger.DEBUGINFO, "This was the error now debugging is compeled");
    }

    public static Logger doChaining() {
        ConsoleBasedLogger consoleBasedLogger = new ConsoleBasedLogger(Logger.OUTPUTINFO);

        ErrorBasedLogger errorBasedLogger = new ErrorBasedLogger(Logger.ERRORINFO);
        consoleBasedLogger.setNextLevelLogger(errorBasedLogger);

        DebugBasedLogger debugBasedLogger = new DebugBasedLogger(Logger.DEBUGINFO);
        errorBasedLogger.setNextLevelLogger(debugBasedLogger);

        return consoleBasedLogger;
    }
}
