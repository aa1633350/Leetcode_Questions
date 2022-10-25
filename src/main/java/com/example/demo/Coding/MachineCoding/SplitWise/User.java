package com.example.demo.Coding.MachineCoding.SplitWise;

import java.util.List;

public class User {

    private int id;
    private String name;
    private String email;
    private int mobileNo;
    private int amount;
    public User(int id, String name, String email, int mobileNo, int amount) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobileNo = mobileNo;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addAmount(int id, int amount, List<Integer> usersWhoOwe, Expense expense) {


    }


}
