package com.example.demo.Coding.GeneralCode;

import java.util.Collections;
import java.util.List;

public class AlmostSorted {
    public static void almostSorted(List<Integer> arr) {
        int start=-1;
        for(int i=0;i<arr.size()-1;i++){
            if(arr.get(i)>arr.get(i+1)){
                start=i;
                break;
            }
        }
        if(start == -1) {
            System.out.println("yes");
            return;
        }
        int end=-1;
        for(int i=arr.size()-1;i>0;i--){
            if(arr.get(i) < arr.get(i-1)) {
                end=i;
                break;
            }
        }
        Collections.swap(arr,start,end);
    }

}
