package com.example.demo.Coding.GeneralCode;

import java.util.*;

public class GetMaxLenProdcutArray {

    public static int getMaxLen(int[] nums) {

        List<List<Integer>> listOfArr = new ArrayList<>();
        int negCount = 0, finalNegCount=0;
        List<Integer> l = new ArrayList<>();
        List<Integer> countOfNegativeInList = new ArrayList<>();
        for(int i : nums) {
            if(i==0) {

                listOfArr.add(l);
                countOfNegativeInList.add(negCount);
                negCount=0;
                l = new ArrayList<>();
                //l.clear();
            } else{
                l.add(i);
            }

            if(i<0){
                negCount++;
                finalNegCount++;
            }
        }
        listOfArr.add(l);
        countOfNegativeInList.add(negCount);
        if(listOfArr.size() == 1 && finalNegCount % 2==0){
            return nums.length;
        }
        int ans = 0;
        for(int i = 0; i<listOfArr.size(); i++){
            List<Integer> list = listOfArr.get(i);
            int negatives = countOfNegativeInList.get(i);
            if(negatives%2==0){
                ans=Math.max(ans,list.size());
            } else{
                int prefixLen=0, suffixLen = 0;
                for(int j=0;j<list.size();j++) {
                    if(list.get(j)<0){
                        prefixLen = list.size()-j-1;
                        break;
                    }
                }
                for(int j=list.size()-1; j>=0; j--) {
                    if(list.get(j)<0){
                        suffixLen = j;
                        break;
                    }
                }
                ans = Math.max(ans,Math.max(prefixLen,suffixLen));
            }
        }
        return ans;


    }

    public static void main(String[] args) {
        int arr [] = {0,1,-2,-3,-4};
        //System.out.println(getMaxLen(arr));
        Queue<Integer> q = new LinkedList<>();
        q.add(2);
        q.add(3);
        q.remove();
        System.out.println(q);
        Stack<Integer> st = new Stack<>();
        st.add(2);
    }
}
