package com.example.demo.Coding.MachineCoding.LoggerFramework;

import static com.example.demo.Coding.MachineCoding.LoggerFramework.LogManager.buildChainOfLogger;

public class LoggerDriver {

    static LoggerDriver instance;
    static AbstractLogger chainOfLogger;
    public static LoggerDriver getInstance() {
        if(instance == null) {
            instance = new LoggerDriver();
            chainOfLogger = buildChainOfLogger();
        }
        return instance;
    }

    private void createLog(int level, String msg){
        chainOfLogger.logMessage(level,msg);
    }

    public void info (String msg) {
        createLog(1,msg);
    }

    public void error (String msg) {
        createLog(2,msg);
    }

    public void debug (String msg) {
        createLog(3,msg);
    }

}
