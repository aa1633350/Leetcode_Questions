package com.example.demo.Coding.MachineCoding.CopiedSplitWise;

import java.util.Map;

public class PercentSplitType implements SplitType{
    ExpenseGroup expenseGroup;
    @Override
    public double getPart(User user) throws IllegalPercentSplitGiven {

        if(!isPercentSplitSumEqualTo100())
        {
            throw new IllegalPercentSplitGiven("total sum of percent does not equal to 100");
        }

        return expenseGroup.getTransactionAmount()*expenseGroup.getPercentSplit().get(user)/100;
    }

    public PercentSplitType(ExpenseGroup expenseGroup) {
        this.expenseGroup = expenseGroup;
    }

    private boolean isPercentSplitSumEqualTo100()
    {
        int total = 0;
        for (Map.Entry<User,Integer> entry : expenseGroup.getPercentSplit().entrySet()) {
            total += entry.getValue();
        }

        return total == 100;
    }
}
