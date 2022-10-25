package com.example.demo.Coding.GeneralCode;

public class IntegerToRoman {

    public static class Pair {
        int num;
        String s;
        Pair(int num, String s) {
            this.num = num;
            this.s = s;
        }
    }
    private static Pair findValue(int num) {

        if (num>1000) {
            return new Pair(num - 1000, "M");
        } else if (num>500) {
            return new Pair(num - 500, "D");
        } else if (num>100) {
            return new Pair(num - 100, "C");
        } else if (num>50) {
            return new Pair(num - 50, "L");
        } else if (num > 40) {
            return new Pair(num - 40, "XL");
        } else if (num>10) {
            return new Pair(num - 10, "X");
        } else if (num>5) {
            return new Pair(num - 5, "V");
        } else if(num == 4){
            return new Pair(0, "IV");
        } else {
            return new Pair(num-1, "I");
        }

    }
    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        Pair p;
        while(num>0) {
            p = findValue(num);
            sb.append(p.s);
            num = p.num;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(40));
    }
}
