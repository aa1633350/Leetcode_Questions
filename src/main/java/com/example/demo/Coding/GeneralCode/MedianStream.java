package com.example.demo.Coding.GeneralCode;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianStream {


    // maxHeap left main
    private PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
    // minHeap right main
    private PriorityQueue<Integer> minheap = new PriorityQueue<>();
    private boolean even = true;

    public double findMedian() {
        if (even)
            return (maxheap.peek() + minheap.peek()) / 2.0;
        else
            return maxheap.peek();
    }

    public void addNum(int num) {
        if (even) {
            minheap.offer(num);
            maxheap.offer(minheap.poll());
        } else {
            maxheap.offer(num);
            minheap.offer(maxheap.poll());
        }
        even = !even;
    }

    public static void main(String[] args) {
        MedianStream medianStream = new MedianStream();
        medianStream.addNum(2);
        medianStream.addNum(4);
        System.out.println(medianStream.findMedian());
        medianStream.addNum(3);
        System.out.println(medianStream.findMedian());
    }
}
