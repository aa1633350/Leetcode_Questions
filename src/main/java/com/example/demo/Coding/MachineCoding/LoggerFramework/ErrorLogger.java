package com.example.demo.Coding.MachineCoding.LoggerFramework;

public class ErrorLogger extends AbstractLogger{

    public ErrorLogger(int level) {
        this.level= level;
    }
    @Override
    protected void display(String msg) {
        System.out.println("ERROR : " + msg);
    }
}
