package com.example.demo.Coding.Recursion;

public class PowerSum {
    static int [] answer = new int [6];
    public static int recur ( int x , int n , int i){
        int value = (int)(x-Math.pow(i,n));
        if(value < 0){
            return 0;
        }
        if(value == 0) {
            return 1;
        }
        if (answer[x] != 0) {
            return answer[value];
        }
        else{
            answer[x] = recur(value, n, i+1) + recur(x, n, i+1);
            return answer[x];
        }

    }
    public static int powerSum(int X, int N) {

        return recur(X , N , 1);


    }

    public static void main(String[] args) {
        System.out.println(powerSum(5,2));
        for (int x : answer) {
            System.out.print(x + " ");
        }
    }
}
