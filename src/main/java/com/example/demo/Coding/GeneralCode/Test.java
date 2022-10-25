package com.example.demo.Coding.GeneralCode;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {


    static String swap(String str){
        StringBuilder sb = new StringBuilder(str);
        int len = str.length();
        for(int i=0;i<len/2;i++){
            char current = sb.charAt(i);
            char otherEnd = sb.charAt(len-i-1);
            sb.setCharAt(i,otherEnd);
            sb.setCharAt(len-i-1, current);
        }
        return sb.toString();
    }
    static void swapArr(char [] chars , int begin, int end) {
        char temp = chars[begin];
        chars[begin]=chars[end-1];
        chars[end-1]=temp;
    }

    private static void fly(long []  miles) {
        System.out.println("Miles in integer" + miles[1]);
        //return miles;
    }


    private static void fly(int... miles) {
        System.out.println("Miles in short " + miles[1]);
        //return true;
    }
    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    static boolean allPossiblePermutations (String num, int l , int r, boolean x) {
        if(l==r) {
            // check and return if it is power of two
            System.out.println(num);
            int value = Integer.parseInt(num);
            return value !=0 && ((value & value-1) ==0);
        }

        for(int i=l;i<=r;i++) {
            num = swap(num,l,i);
            x = x | allPossiblePermutations(num,l+1,r,x);
            num = swap(num,l,i);

        }
        return x;
    }
    public static boolean reorderedPowerOf2(int n) {
        if(n==1){
            return true;
        }
        int copy_n = n;
        int lastDigit=0;
        boolean canBePower = false;
        while(copy_n>0) {
            lastDigit = copy_n % 10;
            if(lastDigit == 2 || lastDigit == 4 || lastDigit == 8 || lastDigit == 6) {
                canBePower = true;
                break;
            }
            copy_n/=10;
        }

        if(!canBePower) {
            return false;
        }
//
//        String num = String.valueOf(n);
//        boolean [] used = new boolean [10];
        return allPossiblePermutations(String.valueOf(n), 0, String.valueOf(n).length()-1, false);
    }
    public static void main(String[] args) throws IOException {
        //boolean [] used = new boolean [10];
        System.out.println(reorderedPowerOf2(55366));
//        Stack <Integer> st = new Stack<>();
//        Map<Integer,List<Integer>> map = new HashMap<>();
//        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
//            int key = entry.getKey();
//            List<Integer> temp = entry.getValue();
//        }
//        st.pop();
//        byte b = (byte) 0xfff;
//        System.out.println(b);
//            short mask = 0xfff;
//        System.out.println(mask);
//            String x = "Aditya";
//            x=x.concat("Anand");
//        System.out.println(x);
//        String s = "phonephons";
//        int idx = (s+s).indexOf(s,1);
//        System.out.println(idx);
//        String s = "leet";
//        System.out.println(s.replace(s.charAt(1),'a'));
//        List<Integer> l1 = new ArrayList<>();
//        l1.add(1);
//        l1.add(2);
//        l1.add(3);
//        l1.add(1);
//        l1.add(2);
//        l1.add(3);
//        List<Integer> l2 = new ArrayList<>();
//        l2.add(11);
//        l2.add(22);
//        l2.add(33);
//        l2.add(14);
//        l2.add(25);
//        l2.add(36);
//        List<Integer> l3 = new ArrayList<>();
//        l3.addAll(l1);
//        l3.addAll(l2);
//        for(int x : l3){
//            System.out.println(x);
//        }

//        StringBuilder sb =new StringBuilder("Aditya");
//        new StringBuilder("Aditya");
//        StringBuilder sb1;
//        sb1=sb;
//        sb = new StringBuilder(sb.substring(1, 3)); // new String Builder object is being created
//        System.out.println(sb==sb1);
//        System.out.println(sb1);
//        System.out.println(sb==sb1);
//        System.out.println(sb.equals(sb1));
//        String a = "aditya";
//        String b = new String("aditya");
//        System.out.println("String " + a.equals(b));
//        System.out.println("S"+a==b);
//        List chimpanzees = new ArrayList<Integer>();
//
//        var s = "Hello";
//        var t = new String(s);
//        if ("Hello".equals(s)) System.out.println("one");
//        if (t == s) System.out.println("two");
//        if (t.intern() == s) System.out.println("three");
//        if ("Hello" == s) System.out.println("four");
//        if ("Hello".intern() == t) System.out.println("five");
//        StringBuilder sb = new StringBuilder();
//
//        sb.append("aaa").insert(1, "bb").insert(4, "ccc");
//        System.out.println(sb.substring(7,7));
//        System.out.println(sb);
//        String x = "aditya";
//        String y = "aditya";
//        System.out.println(x==y);
//
//        StringBuilder numbers = new StringBuilder("0123456789");
//        numbers.delete(2,  8);
//        numbers.append("-").insert(2, "+");
//        System.out.println(numbers);
//        List<Integer> arrList = new ArrayList<>();
//        arrList.add(1);
//        arrList.add(1);
//        System.out.println(arrList.get(1));
//        System.out.println(arrList.get(2));


//        List<Integer> list  = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(1);
//        list.add(3);
//        System.out.println(list);
//        long d= 100L;
//        int high = (int)Math.pow(3,19);
//        if(high % 3==0){
//            System.out.println("jj");
//        }
//        System.out.println(high);
//        System.out.println(Integer.MAX_VALUE);
    }

    private int [] fun () {
        return new int[] {-1};

    }


}

//Maa chod denge oracle ki