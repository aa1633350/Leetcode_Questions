package com.example.demo.Coding.MachineCoding.LoggerFramework;

public class DebugLogger extends AbstractLogger{

    public DebugLogger(int level) {
        this.level = level;
    }

    @Override
    protected void display(String msg) {
        System.out.println("DEBUG : " + msg);
    }
}
