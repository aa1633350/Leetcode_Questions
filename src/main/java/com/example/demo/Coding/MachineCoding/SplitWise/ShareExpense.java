package com.example.demo.Coding.MachineCoding.SplitWise;

import java.util.List;

public class ShareExpense {
    List<User> usersList;
    public ShareExpense(List<User> usersList) {
        this.usersList = usersList;
    }

    public void shareExpenseEqually(String name , double amount, List<User> owedUser) {
        
        double owedAmount = amount/owedUser.size();
        for(User u : owedUser) {

        }

    }
}
