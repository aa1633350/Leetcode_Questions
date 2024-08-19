package com.example.demo.InterfaceCheck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestingClass {

    private void testMethod() {
        double x = A.pi;
    }

    public static void main(String[] args) {
        A functionalInterfaceObj = (String s)-> {
            String upperCaseName = s.toUpperCase();
            return upperCaseName.concat(" paypal");
        };

        System.out.println(functionalInterfaceObj.helloFunctionalInterface("aditya"));
    }




//    // Sexy way to create graph.
//    public int[] countSubTrees(int n, int[][] edges, String labels) {
//        Map<Integer, List<Integer>> g = new HashMap<>();
//        for (int[] e : edges) {
//            g.computeIfAbsent(e[0], l -> new ArrayList<>()).add(e[1]);
//            g.computeIfAbsent(e[1], l -> new ArrayList<>()).add(e[0]);
//        }
//        return null;
//    }

}
