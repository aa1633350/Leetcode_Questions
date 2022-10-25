package com.example.demo.Coding.MachineCoding.LoggerFramework;

public abstract class AbstractLogger {

    int level;
    AbstractLogger nextLoggingLevel;

    public void setNextLoggingLevel(AbstractLogger nextLoggingLevel) {
        this.nextLoggingLevel = nextLoggingLevel;
    }

    void logMessage(int level, String msg) {
        if(this.level <= level){
            display(msg);
        }

        if(nextLoggingLevel!=null) {
            nextLoggingLevel.logMessage(level,msg);
        }
    }

    protected abstract void display(String msg);
}
