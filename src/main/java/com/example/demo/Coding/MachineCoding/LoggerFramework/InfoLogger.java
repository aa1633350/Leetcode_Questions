package com.example.demo.Coding.MachineCoding.LoggerFramework;

public class InfoLogger extends AbstractLogger{

    public InfoLogger(int level) {
        this.level = level;
    }

    @Override
    protected void display(String msg) {
        System.out.println("INFO : " + msg);
    }
}
