package com.example.demo.Coding.MachineCoding.SplitWise;

public enum Expense {
    EQUAL,EXACT,PERCENT;

    public static Expense of(String s) {
        switch(s) {
            case "EQUAL":
                return Expense.EQUAL;
            case "EXACT":
                return Expense.EXACT;
            case "PERCENT":
                return Expense.PERCENT;
            default:
                return null;
        }
    }
}
