package com.example.demo.Coding.Recursion;

import java.util.*;


public class GetAllMagnetsMinimumTime {

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

//        @Override
//        public boolean equals(Node obj) {
//            return obj.x == this.x && obj.y == this.y;
//        }

        @Override
        public int hashCode() {
            return x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        //    @Override
//     public String toString() {
//
//    }


    }

    static int minTime(int d, List<Integer> x , List<Integer>y) {

        int n = x.size();
        Queue<Node> q = new LinkedList<>();
        HashSet<Node> hashSet = new HashSet<>();
        HashSet<Node> checkValues = new HashSet<>();
        for(int i=0;i<n;i++) {
            hashSet.add(new Node(x.get(i), y.get(i)));
        }
        int time=0;
        for(int k=0;k<n;k++) {
            int a = x.get(k);
            int b = y.get(k);
            Node newNode = new Node(a, b);
            if(!checkValues.contains(newNode)) {
                q.add(newNode);
                while (!q.isEmpty()) {
                    int size = q.size();

                    while(size-- > 0) {

                        Node node = q.poll();
                        int currX = node.x;
                        int currY = node.y;

                        for(int i=1;i<=d;i++) {

                            if(hashSet.contains(new Node (currX+1, currY)) && !checkValues.contains(new Node (currX+1, currY))) {
                                Node tempNode = new Node(currX+1, currY);
                                q.add(tempNode);
                                checkValues.add(tempNode);
                            }

                            if(hashSet.contains(new Node (currX, currY+1)) && !checkValues.contains(new Node (currX, currY+1))) {
                                Node tempNode = new Node(currX, currY+1);
                                q.add(tempNode);
                                checkValues.add(tempNode);

                            }
                            if(hashSet.contains(new Node (currX-1, currY)) && !checkValues.contains(new Node (currX-1, currY))) {
                                Node tempNode = new Node(currX-1, currY);
                                q.add(tempNode);
                                checkValues.add(tempNode);

                            }
                            if(hashSet.contains(new Node (currX, currY-1)) && !checkValues.contains(new Node (currX, currY-1))) {
                                Node tempNode = new Node(currX, currY-1);
                                q.add(tempNode);
                                checkValues.add(tempNode);
                            }


                        }
                    }

                }
                time++;
            }
        }




        return time;

    }

    public static void main(String[] args) {

        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();

        x.add(0);
        x.add(1);
        x.add(0);
        x.add(1);

        y.add(0);
        y.add(2);
        y.add(1);
        y.add(0);

        System.out.println(minTime(2,x,y));
    }
}
