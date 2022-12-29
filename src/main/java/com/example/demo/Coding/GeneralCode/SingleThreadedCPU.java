package com.example.demo.Coding.GeneralCode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SingleThreadedCPU {

    static class Task {

        int eT;
        int pT;
        int index;
        Task(int eT, int pT, int index) {
            this.eT = eT;
            this.pT = pT;
            this.index = index;
        }
    }
    public static int[] getOrder(int[][] tasks) {
        int n = tasks.length,i=0;
        Task [] arr = new Task [n];
        int [] ans = new int [n];
        for(int [] task : tasks) {
            arr[i] = new Task(task[0],task[1],i);
            i++;
        }
        // Sort the Tasks object array cause the input may be like [[19,13],[16,9],[21,10],[32,25]]
        Arrays.sort(arr, (Task t1, Task t2) -> {
            return Integer.compare(t1.eT,t2.eT);
        });
        // Priority Queue Definitiom
        PriorityQueue<Task> pq = new PriorityQueue<>((Task t1, Task t2) -> {
            if(t1.pT == t2.pT) {
                return Integer.compare(t1.index, t2.index);
            } else {
                return Integer.compare(t1.pT, t2.pT);
            }
        });

        int ansIdx = 0;
        int taskIdx = 0;
        int currTime = 0;

        while(ansIdx < n) {

            while(taskIdx < n && arr[taskIdx].eT<=currTime) {
                pq.offer(arr[taskIdx]);
                taskIdx++;
            }

            if(pq.isEmpty()) {
                currTime = arr[taskIdx].eT;
            } else {
                Task currTask = pq.poll();
                currTime += currTask.pT;
                ans[ansIdx++] = currTask.index;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int [][] tasks = {{1,2},{1,1},{3,2},{4,1}};
        int [] ans = getOrder(tasks);
        for(int a : ans) {
            System.out.print(a + " ");
        }
    }
}
