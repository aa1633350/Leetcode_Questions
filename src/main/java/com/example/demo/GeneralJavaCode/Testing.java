package com.example.demo.GeneralJavaCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Testing {

    Testing() {
        System.out.println("Ins");
    }
    public static void main(String[] args) {

        Testing testing = new Testing();

    }

    private int fun() {
        List<Integer> list = new ArrayList<>();

        Collections.sort(list);
        int count=0,ans=0;
        for(int i=0;i<list.size()-1;i++) {
            if(list.get(i+1)-list.get(i)==1 || list.get(i+1)-list.get(i)==0) {
                count++;
            } else {
                count=0;
            }

            ans = Math.max(ans,count);
        }
        return ans;
    }
}
