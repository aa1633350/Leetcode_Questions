package com.example.demo.Coding.GeneralCode;

public class PasswordMatcher {

    public static int minimumNumber(int n, String password) {
        int count =0;
        if((password.matches("([a-z])"))) {
            count++;
        }
        if((password.matches("([A-Z])"))) {
            count++;
        }
        if((password.matches("([0-9])"))) {
            count++;
        }
        if((password.matches("(\\W)"))) {
            count++;
        }

        return 6-password.length() > count ? 6-password.length() : count;
    }

    public static void main(String[] args) {
        minimumNumber(3,"Ab1");
    }
}
