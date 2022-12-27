package com.example.demo.Coding.GeneralCode;

import java.util.*;

public class TaskScheduler {

    static class Node {
        char ch;
        int freq;
        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }
    public static int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : tasks) {
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        List<Node> list = new ArrayList<>();
        list.forEach(l -> {
            System.out.println(l.freq);
        });
        for(Map.Entry<Character,Integer> entry : map.entrySet()) {
            list.add(new Node(entry.getKey(), entry.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        sb.trimToSize();
        Collections.sort(list, (Node n1, Node n2)-> {
            // n2.freq - n1.freq;
            if(n2.freq < n1.freq) {
                return -1;
            } else if(n2.freq == n1.freq) {
                return 0;
            } else {
                return 1;
            }
        });

        // for(Node node : list) {
        //     System.out.println(node.ch + '->' + node.freq);
        // }
        char[] ans = new char[(len*n)+1];
        int count=0,global=0;
        for(Node node : list) {
            int currFreq = node.freq;
            char ch = node.ch;
            if(count<(len*n)+1 && ans[count]=='\u0000') {
                for(int i=count;i<=(currFreq*n)+count;i+=n+1) {
                    ans[i]=ch;
                    global=i;
                    // ans.add(i,ch);
                }
                count++;
            } else {
                while(count<(len*n)+1 && ans[count]!='\u0000') {
                    count++;
                }
            }
        }
        return global+1;



    }

    public static void main(String[] args) {
        char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G'};
        System.out.println(leastInterval(tasks,2));
    }
}
