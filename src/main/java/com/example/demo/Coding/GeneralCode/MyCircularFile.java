package com.example.demo.Coding.GeneralCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class MyCircularQueue {

    int [] q;
    int front,rear;
    public MyCircularQueue(int k) {
        q = new int [k];
        Arrays.fill(q,-1);
        front=0;
        rear=front-1;
    }

    public boolean enQueue(int value) {
        if(!isFull()) {
            q[front]=value;
            front++;
            if(front==q.length) {
                front=0;
            }
            return true;
        }
        return false;
    }

    public boolean deQueue() {
        if(!isEmpty()) {
            rear++;
            q[rear]=-1;
            if(rear==q.length) {
                front=0;
            }
            return true;
        }

        return false;
    }

    public int Front() {
        if(isEmpty()) {
            return -1;
        }
        return q[front];
    }

    public int Rear() {
        if(isEmpty()) {
            return -1;
        }
        if(rear==-1) {
            rear=0;
        }
        return q[rear];
    }

    public boolean isEmpty() {
        for(int i : q) {
            if(i != -1) {
                return false;
            }
        }

        return true;
    }

    public boolean isFull() {
        for(int i : q) {
            if(i == -1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
//        System.out.println(myCircularQueue.enQueue(1));
//        System.out.println(myCircularQueue.enQueue(2));
//        System.out.println(myCircularQueue.enQueue(3));
//        System.out.println(myCircularQueue.enQueue(4));
//        //System.out.println(myCircularQueue.deQueue());
//        //System.out.println("front is " + myCircularQueue.front);
//        System.out.println(myCircularQueue.Rear());
//        System.out.println(myCircularQueue.Rear());
//        System.out.println(myCircularQueue.Rear());

        String s = "==";
        String y = "!=";
        List<Integer> ans = new ArrayList<>();
        Collections.sort(ans);
        int [] arr = {1,2,3,14,18};
        System.out.println(Arrays.binarySearch(arr,-1));
        //System.out.println(s.compareTo(y));

    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */