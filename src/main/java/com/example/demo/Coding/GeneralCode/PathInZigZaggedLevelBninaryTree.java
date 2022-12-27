package com.example.demo.Coding.GeneralCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PathInZigZaggedLevelBninaryTree {

    public static void pathInZigZagTree(int label) {
        String x = "aa";
        
        int level = 0;
        int value = 1;
        int idx = 0;
        int [] arr = new int [1000001];
        arr[0]=1;
        Queue<Integer> node = new LinkedList<>();
        node.add(0);
        while(value <=label) {
            int numOfNodes = 0;
            int size = node.size();
            while(numOfNodes<size) {
                idx = node.poll();
                if(level%2 !=0) { // go right to left
                    int right=2*idx+2;
                    int left = 2*idx+1;
                    arr[right]=++value;
                    arr[left]=++value;

                    node.add(right);
                    node.add(left);

                } else { // go left to right;
                    int right=2*idx+2;
                    int left = 2*idx+1;
                    arr[left]=++value;
                    arr[right]=++value;
                    node.add(left);
                    node.add(right);
                }
                numOfNodes++;
            }

            level++;
        }

        for(int i=0;i<100;i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        pathInZigZagTree(14);
    }
}
