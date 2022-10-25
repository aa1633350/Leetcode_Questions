package com.example.demo.Coding.GeneralCode;

public class TestDefPath {
    private final String testDefAbsPath;
    private final String MODULES = "modules/";
    public TestDefPath(String testDefAbsPath) {
        if(!testDefAbsPath.contains(MODULES)) {
            throw new IllegalArgumentException("Absolute path must contain \"modules\"");
        }
        this.testDefAbsPath = testDefAbsPath;
    }

    public void Hello() {
        System.out.println("Helo");
    }
}
