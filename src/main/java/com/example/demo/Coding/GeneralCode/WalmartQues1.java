package com.example.demo.Coding.GeneralCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WalmartQues1 {


    // [[1,3],[2,6],[8,10],[15,18]]

    // [1,6] [8,10] [15,18]

    // [[5,7],[3,6],[7,11],[14,19]] --> [[3,6],[5,7],[7,11],[14,19]]
    // [5,21]

    // sort on 2nd column (i.e ending bus stop) and merge the overlapping intervals.

    private static List<List<Integer>> findMinBusStops(int [][] routes) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(routes, (int [] r1, int [] r2) -> {
            return r1[0]-r2[0];
        });
        int start = routes[0][0];
        int endStop = routes[0][1];
        for(int i=1;i<routes.length;i++) {

            if(endStop >= routes[i][0]) {
                endStop = Math.max(endStop, routes[i][1]);
            } else {
                List<Integer> mergedRoute = new ArrayList<>();
                mergedRoute.add(start);
                mergedRoute.add(endStop);
                ans.add(mergedRoute);
                start = routes[i][0]; // 14
                endStop = routes[i][1]; // 19
            }
        }
        List<Integer> mergedRoute = new ArrayList<>();
        mergedRoute.add(start);
        mergedRoute.add(endStop);
        ans.add(mergedRoute);
        return ans;
    }

    public static void main(String[] args) {
        int [][] routes = {{3,7}, {2,3}, {8,10}, {15,18}};
        //routes = {[1,3],[2,6],[8,10],[15,18]}
        List<List<Integer>> finalRoutes = findMinBusStops(routes);
        for(List<Integer> l : finalRoutes) {
            System.out.println(l.get(0) + " " + l.get(1));
        }
    }
}
