package com.example.demo.Coding.DP;

public class GetMaximumScore {

    static class Target {

        int value;
        int whichArray;

        Target(int value,int whichArray) {
            this.value = value;
            this.whichArray = whichArray;
        }
    }
    public static int maxSum(int[] nums1, int[] nums2) {


        int len1 = nums1.length, sum1=0;
        int len2 = nums2.length, sum2=0;
        int i=0,j=0,count=0;
        Target [] merged = new Target[len1+len2];
        int [] dp = new int[len1+len2];
        // Merge arrays
        while(i<len1 && j<len2) {
            if(nums1[i]<=nums2[j]) {
                sum1+=nums1[i];
                Target obj = new Target(nums1[i],1);
                merged[count] = obj;
                i++;

            } else {
                sum2+=nums2[j];
                Target obj = new Target(nums2[j],2);
                merged[count] = obj;
                j++;
            }
            count++;

        }

        while(i<len1) {
            sum1+=nums1[i];
            Target obj = new Target(nums1[i],1);
            merged[count] = obj;
            i++;
            count++;
        }

        while(j<len2) {
            sum2+=nums2[j];
            Target obj = new Target(nums2[j],2);
            merged[count] = obj;
            j++;
            count++;
        }


        Target curr=merged[0],prev=null;
        dp[0]=curr.value;
        int prevIdxOne=-1,prevIdxTwo=-1;
        if(curr.whichArray==1){
            prevIdxOne=0;
        } else {
            prevIdxTwo = 0;
        }
        for(int p=1;p<merged.length;p++) {
            prev=curr;
            curr=merged[p];

            if(prev.value != curr.value) {
                if(curr.whichArray==1) {
                    dp[p]=dp[prevIdxOne]+curr.value;
                } else {
                    dp[p]=dp[prevIdxTwo]+curr.value;
                }

            } else {
                if(curr.whichArray==1) {
                    if(prevIdxOne!=-1) {
                        dp[p]=Math.max(dp[p-1], dp[prevIdxOne] + curr.value);
                    } else {
                        dp[p]=dp[p-1];
                    }

                } else {
                    if(prevIdxTwo!=-1) {
                        dp[p]=Math.max(dp[p-1], dp[prevIdxTwo] + curr.value);
                    } else {
                        dp[p]=dp[p-1];
                    }

                }
                // update both values with the max.
                dp[p-1]=dp[p];
            }

            if(curr.whichArray==1) {
                prevIdxOne = p;
            } else {
                prevIdxTwo = p;
            }

        }

        // for(int k=0;k<dp.length;k++) {
        //     System.out.print(dp[k] + " ");
        // }

        return Math.max(prevIdxOne != -1 ? dp[prevIdxOne] : sum1, prevIdxTwo != -1 ? dp[prevIdxTwo] : sum2);
    }

    public static void main(String[] args) {

        int [] num1 = {1,2,3,4,5};
        int [] num2 = {6,7,8,9,10};
        System.out.println(maxSum(num1,num2));
    }
}
