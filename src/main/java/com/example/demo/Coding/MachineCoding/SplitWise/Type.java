package com.example.demo.Coding.MachineCoding.SplitWise;

public enum Type {
    EXPENSE("EXPENSE"),
    SHOW("SHOW"),
    QUIT("QUIT");

    private final String name;
    Type(String s) {
        name = s;
    }


    public static Type of(String type) {
        if(type.equals(Type.EXPENSE.toString())) {
            return Type.EXPENSE;
        } else if(type.equals(Type.SHOW.toString())) {
            return Type.SHOW;
        } else {
            return Type.QUIT;
        }

    }
}
