package com.example.demo.Coding.GeneralCode;

public class Kaprekar {
    public static void kaprekarNumbers(int p, int q) {
        if (p == 1) {
            System.out.print("1 ");
        }
        int square=0;
        String num="";
        // String left = "";
        // String right = "";

        boolean flag = false;
        for (int i=p ; i<=q ; i++){
            int sum=0;
            square = i*i;
            num = Integer.toString(square);
            for ( int digits = 1 ; digits < num.length(); digits++) {
                int div = (int)Math.pow(10,digits);
                if (div == i) {
                    continue;
                }
                sum = (square/div) + (square%div);
                if (sum == i) {
                    flag = true;
                    System.out.print(i + " ");
                }
            }
        }

        if(!flag) {
            System.out.print("INVALID RANGE");
        }

    }

    public static void main(String[] args) {
        kaprekarNumbers(1000,10000);
    }

}

//1 9 45 55 99 297 703 999 2223 2728 4879 4950 5050 5292 7272 7777 9999