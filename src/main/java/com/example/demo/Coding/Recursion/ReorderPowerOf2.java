package com.example.demo.Coding.Recursion;

import java.util.Arrays;

public class ReorderPowerOf2 {

    private String swap(String str , int l , int r) {
        char temp;
        char [] arr = str.toCharArray();
        temp=arr[l];
        arr[l]=arr[r];
        arr[r]=temp;
        return String.valueOf(arr);
    }
    private boolean allPossiblePermutations (String num, int l , int r, boolean x) {
        if(l==r) {
            // check and return if it is power of two
            //System.out.println(num);
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

    public boolean reorderedPowerOf2(int n) {
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

        String num = String.valueOf(n);
        return allPossiblePermutations(num, 0, num.length()-1, false);
    }

    public static void main(String[] args) {

    }
}
