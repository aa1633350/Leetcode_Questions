package com.example.demo.Coding.MachineCoding.CopiedSplitWise;

import java.util.Map;

public class ExactSplitType implements SplitType{
    ExpenseGroup expenseGroup;
    @Override
    public double getPart(User user) throws IllegalExactSplitGiven{

        if(getExactSplitSum() != expenseGroup.getTransactionAmount())
        {
            throw new IllegalExactSplitGiven("sum of participants not equal to total tx amount");
        }

        return expenseGroup.getExactSplit().get(user);
    }
    public ExactSplitType(ExpenseGroup expenseGroup) {
        this.expenseGroup = expenseGroup;
    }

    private double getExactSplitSum()
    {
        double givenByUser = 0;
        for (Map.Entry<User,Double> entry: expenseGroup.getExactSplit().entrySet()) {
            givenByUser += entry.getValue();
        }
        return givenByUser;
    }

}
