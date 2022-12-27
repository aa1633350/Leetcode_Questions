package com.example.demo.Coding.Recursion;

public class LCMofArray {

    private int gcd(int a, int b) {

        if(a==b) {
            return a;
        } else if(a>b) {
            return gcd(a-b,b);
        } else {
            return gcd(a,b-a);
        }

    }
    private void lcm(int [] arr) {
        int ans = arr[0];
        for(int i=1;i<arr.length;i++) {
            System.out.println(ans);
            int numerator = ans*arr[i];
            int deno = gcd(ans,arr[i]);
            ans = numerator/deno;
        }
        System.out.println(ans);
        //return ans;
    }

    private void hcfOfArray(int [] arr) {

        int ans = arr[0];
        //System.out.println();
        for(int i=1;i<arr.length;i++) {

            ans = gcd(ans,arr[i]);
            System.out.println(ans);
        }
        //System.out.println(ans);
    }

    private void printArray(int [] nums) {

        int len = nums.length;
        for(int i=0;i<len;i++) {
            System.out.println(nums[i]);
            for(int j=i+1;j<len;j++) {

            }

        }
    }
    public static void main(String[] args) {

        int [] arr = {6,2,7};
        LCMofArray lcMofArray = new LCMofArray();
        //lcMofArray.printArray(arr);
        lcMofArray.lcm(arr);
        System.out.println("---------------------");
        lcMofArray.hcfOfArray(arr);
        //System.out.println(lcMofArray.lcm(arr));
    }
}
