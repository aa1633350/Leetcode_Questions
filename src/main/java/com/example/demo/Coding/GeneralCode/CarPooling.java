package com.example.demo.Coding.GeneralCode;

import java.util.*;

public class CarPooling {
        public static boolean carPooling(int[][] trips, int capacity) {

            int row = trips.length;
            int col = trips[0].length;
            Arrays.sort(trips , (int [] a1, int [] a2) -> {
                if(a1[1]>a2[1]) {
                    return 1;
                } else {
                    return -1;
                }

            });
            Map<Integer,Integer> dropOff = new HashMap<>();
            PriorityQueue<Integer> q = new PriorityQueue<>();
            int newCapacity = capacity - trips[0][0];
            //System.out.println(newCapacity);
            //int prevSrc = trips[0][1];
            int prevDest = trips[0][2];
            q.add(prevDest);
            int nextSrc=0, nextDest=0;
            dropOff.put(prevDest,trips[0][0]);
            for(int i=1;i<row;i++) {
                if(newCapacity < 0) {
                    return false;
                }
                nextSrc = trips[i][1];
                nextDest = trips[i][2];

                if(!q.isEmpty() && nextSrc >= q.peek()) {
                    while (!q.isEmpty() && nextSrc >= q.peek()) {
                        int dest = q.poll();
                        newCapacity += dropOff.get(dest);
                        dropOff.remove(dest);
                    }
                    newCapacity -= trips[i][0];
                } else {
                    newCapacity -= trips[i][0];
                }
                if(!q.contains(nextDest)){
                    q.add(nextDest);
                }
                dropOff.put(nextDest, dropOff.getOrDefault(nextDest,0)+trips[i][0]);


            }
            return newCapacity >= 0;
        }


    public static void main(String[] args) {
//            [[9,3,4],[9,1,7],[4,2,4],[7,4,5]]
//        23
//        [[8,2,3],[4,1,3],[1,3,6],[8,4,6],[4,4,8]]
//        12
        //int matrix[][] = {{9,3,4},{9,1,7},{4,2,4},{7,4,5}};
        int matrix[][] = {{8,2,3},{4,1,3},{1,3,6},{8,4,6},{4,4,8}};
        System.out.println(carPooling(matrix,12));
        List<Integer> x = new ArrayList<>();
        Map<Integer,List<Integer>> vertical = new LinkedHashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        //traverseTree(vertical,0,root);
        //vertical.compute(col, (k,v) -> v == null ? new ArrayList<>() : v).add(root.val);
        for(Map.Entry<Integer,List<Integer>> entry : vertical.entrySet()) {
            ans.add(entry.getValue());
        }
        //return ans;
    }
}
