package com.example.demo.Coding.GeneralCode;

public class WinnerOfCircularGame {

    public static int findTheWinner(int n, int k) {

        boolean [] visited = new boolean[n+1];

        int friends = n, start = 1;

        while(friends!=1) {
            int count = 0;
            for(int i=start;i<=n;) {
                if(i!=0 && !visited[i]) {
                    count++;
                }

                if(count==k) {
                    visited[i] = true;
                    friends--;
                    start = (i+1)%(n+1);
                    break;
                }
                i=(i+1)%(n+1);
            }

        }

        for(int i=1;i<=n;i++) {
            if(!visited[i]) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(findTheWinner(5,2));
    }
}
