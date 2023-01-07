package com.example.demo.Coding.GeneralCode;

import java.util.LinkedHashSet;
import java.util.Set;

public class GasStation {


    private int circularTour(int [] gas, int [] cost) {


        int n = gas.length;
        Set<Integer> indexes = new LinkedHashSet<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
            if (gas[i] != 0 && gas[i] - cost[i] >= 0) {
                indexes.add(i);
            }
        }

        if (sum < 0) {
            return -1;
        }
        int fuel = 0, nextStation = 0;
        for (int i : indexes) {
            fuel = gas[i] - cost[i];

            nextStation = (i + 1) % n;
            while (nextStation < n) {
                fuel += gas[nextStation] - cost[nextStation];
                if (fuel < 0) {
                    break;
                }
                nextStation = (nextStation + 1);
            }
            if (fuel >= 0) {
                return i;
            }
            fuel = 0;
        }

        return -1;
    }

}
