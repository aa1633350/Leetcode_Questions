package com.example.demo.Coding.GeneralCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DesignHitCounterEpamSystems {

    //List<Integer> counterList;
    Queue<Integer> q;


    public DesignHitCounterEpamSystems() {
        //counterList = new ArrayList<>();
        q = new LinkedList<>();
    }

//    void hit (int timeStamp) {
//        counterList.add(timeStamp);
//    }
//
//    int getHits(int timeStamp) {
//        int i;
//        for(i=0;i<counterList.size();i++) {
//            if(counterList.get(i) > timeStamp-300) {
//                break;
//            }
//        }
//        return counterList.size()-i;
//    }

    void hit(int timeStamp) {
        q.offer(timeStamp);
    }

    int getHits(int timeStamp) {
        while(!q.isEmpty() && q.peek() <= timeStamp-300) {
            q.poll();
        }
        return q.size();
    }

    public static void main(String[] args) {
        DesignHitCounterEpamSystems counter = new DesignHitCounterEpamSystems();
        counter.hit(1);
        counter.hit(2);
        counter.hit(3);
        System.out.println(counter.getHits(4));
        counter.hit(300);
        System.out.println(counter.getHits(300));
        System.out.println(counter.getHits(301));
    }
}
