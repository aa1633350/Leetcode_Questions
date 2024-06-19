package com.example.demo.Coding.GeneralCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddNumbers {

    public static List<Integer> addToArrayForm(int[] num, int k) {


        List<Integer> ans = new ArrayList<>();
        int len = num.length;
        int carry = 0;
        for(int i=len-1;i>=0;i--) {
            int sum = (k%10 + num[i] + carry);
            k = k/10;
            if(sum >= 10) {
                carry = 1;
                sum = sum % 10;
            } else {
                carry = 0;
            }

            ans.add(sum);
        }

        while(k>0) {
            int sum = (k%10 + carry);
            k = k/10;
            if(sum >= 10) {
                carry = 1;
                sum = sum % 10;
            } else {
                carry = 0;
            }

            ans.add(sum);
        }
        if(carry==1) {
            ans.add(carry);
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        addToArrayForm(new int [] {1,2,0,0}, 34);
    }
}
