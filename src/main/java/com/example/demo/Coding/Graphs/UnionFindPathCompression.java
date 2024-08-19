package com.example.demo.Coding.Graphs;

public class UnionFindPathCompression {

    static int [] parent = {0,1,2,3,4,5,6,7,8,9,10};
    static int [] rank = new int [11];

    private static int findParent(int a) {

        if(parent[a]==a) {
            return a;
        }
        return parent[a]=findParent(parent[a]);

    }
    // initially all are parent of themselves.
    private static void union(int a, int b) {

        int a_parent = findParent(a);
        int b_parent = findParent(b);
        if(a_parent != b_parent) {
            if(rank[a_parent] > rank[b_parent]) {
                parent[b_parent] = a_parent;
            } else if(rank[a_parent] < rank[b_parent]) {
                parent[a_parent] = b_parent;
            } else {
                parent[b_parent] = a_parent;
                rank[a_parent]++;
            }
        }


    }

    public static void main(String[] args) {

        union(1,3);

        union(2,3);
        union(3,6);
        union(5,6);
        union(5,7);
        union(4,5);
        union(4,8);
        union(8,9);
        union(10,2);


        System.out.println("Parent of 6 is "+ findParent(6));

        for(int i=0;i<parent.length;i++) {
            System.out.println("Element "+ i + " parent " + parent[i]);
        }
    }
}
