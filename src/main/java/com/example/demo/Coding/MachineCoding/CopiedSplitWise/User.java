package com.example.demo.Coding.MachineCoding.CopiedSplitWise;

import java.util.HashMap;

public class User {

    private String userId;
    private String name;
    private String email;
    private HashMap<User,Double> balances;


    public HashMap<User, Double> getBalances() {
        return balances;
    }


    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getUserId() {
        return userId;
    }


    public String getName() {
        return name;
    }


    public User(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.balances = new HashMap<>();
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }





    @Override
    public String toString() {
        return "User [name=" + name + "]";
    }


    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User)
        {
            User givenUser = (User)obj;
            return userId.equals(givenUser.getUserId());
        }
        return false;
    }
}
