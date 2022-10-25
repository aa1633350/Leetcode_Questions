package com.example.demo.Coding.GeneralCode;

public class FindWinnerOfCircularGame {

    public static int findTheWinner(int n, int k) {
        int f=n;
        int [] friends = new int [n];
        int start = 1;
        int lostIdx=-1;
        while(n>1) {
            start = (start+k-2)%f;
            while(friends[start]==-1) {
                start=(start+1)%f;
            }
            if(friends[start]!=-1) {
                friends[start]=-1;
                lostIdx = start;
                n--;
            }
            start = (lostIdx+1)%f;
            while(friends[start]==-1) {
                start= (start+1)%f;
            }
        }
        int ans = 0;
        for(int i=0; i<f;i++) {
            if(friends[i]!=-1) {
                ans = i+1;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findTheWinner(6,5));
    }
}
