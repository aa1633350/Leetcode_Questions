package com.example.demo.Coding.MachineCoding.LoggerFramework;

public class LogManager {

    protected static AbstractLogger buildChainOfLogger() {

        AbstractLogger info = new InfoLogger(1);
        AbstractLogger error = new ErrorLogger(2);
        AbstractLogger debug = new DebugLogger(3);

        info.setNextLoggingLevel(error);
        error.setNextLoggingLevel(debug);
        return info;
    }
}
