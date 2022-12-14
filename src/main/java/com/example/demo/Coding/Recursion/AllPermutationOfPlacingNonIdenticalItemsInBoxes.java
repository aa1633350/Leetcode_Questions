package com.example.demo.Coding.Recursion;

import java.io.*;
import java.util.*;

public class AllPermutationOfPlacingNonIdenticalItemsInBoxes {

    // ci -> current item
    // ti -> total item
    // Given 'n' number of boxes and 'r' number of non-identical items print all possible permutations.
    public static void permutations(int[] boxes, int ci, int ti) {
        if (ci > ti) {
            for (int box : boxes) {
                System.out.print(box);
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i] == 0) { // 0 means that the box is empty
                boxes[i] = ci;
                permutations(boxes, ci + 1, ti);
                boxes[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        permutations(new int[nboxes], 1, ritems);
    }

}
