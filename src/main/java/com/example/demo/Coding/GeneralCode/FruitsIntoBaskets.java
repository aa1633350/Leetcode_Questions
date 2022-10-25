package com.example.demo.Coding.GeneralCode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class FruitsIntoBaskets {

    public static int totalFruit(int[] fruits) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        int numOfFruits = fruits.length;
        int collectedFruits = 0;
        for(int i=0;i<numOfFruits-1;i++) {
            int count = 2;
            Set<Integer> basketOne = new HashSet<>();
            Set<Integer> basketTwo = new HashSet<>();
            basketOne.add(fruits[i]);
            for(int j=i+1;j<numOfFruits;j++) {

                if(basketTwo.isEmpty()) {
                    basketTwo.add(fruits[j]);
                    continue;
                }
                if(basketOne.contains(fruits[j]) || basketTwo.contains(fruits[j])) {
                    count++;
                } else {
                    break;
                }
            }
            collectedFruits = Math.max(collectedFruits,count);
        }
        return collectedFruits;
    }

    public static void main(String[] args) {
        System.out.println(totalFruit(new int [] {1,2,1}));
    }
}
