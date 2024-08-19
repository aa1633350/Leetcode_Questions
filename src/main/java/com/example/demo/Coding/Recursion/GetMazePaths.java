package com.example.demo.Coding.Recursion;

import java.util.ArrayList;
import java.util.List;

public class GetMazePaths {
    private static final int matrixSize = 3;
    static List<String> paths = new ArrayList<>();
    public static void main(String[] args) {

//        List<String> paths = getAllMazePaths(2,2,3,3, "");
//        for(String s : paths) {
//            System.out.println(s);
//        }
        List<String> pathsWithJumps = getAllMazePathsWithJumps(1,1,3,3, "");
        for(String s : pathsWithJumps) {
            System.out.println(s);
        }

    }

    private static List<String> getAllMazePaths(int startRow, int startCol, int endRow, int endCol, String s) {
        if(startRow > endRow || startCol > endCol) {
            return new ArrayList<>();
        }
        if(startRow == endRow && startCol == endCol) {
            List<String> temp = new ArrayList<>();
            temp.add(s);
            return temp;
        }

        List<String> hList = getAllMazePaths(startRow, startCol+1,endRow,endCol, s+"h");
        List<String> vList = getAllMazePaths(startRow+1, startCol,endRow,endCol, s+"v");
        List<String> paths = new ArrayList<>();
        paths.addAll(hList);
        paths.addAll(vList);
        return paths;

    }

    private static List<String> getAllMazePathsWithJumps(int startRow, int startCol, int endRow, int endCol, String s) {
//        if(startRow > endRow || startCol > endCol) {
//            return new ArrayList<>();
//        }
        if(startRow == endRow && startCol == endCol) {
            paths.add(s);
            //System.out.println(s);
//            List<String> temp = new ArrayList<>();
//            temp.add(s);
//            return temp;
        }
//        List<String> hList = new ArrayList<>();
//        List<String> vList = new ArrayList<>();
//        List<String> dList = new ArrayList<>();
        for(int i=1;i<=matrixSize-startCol;i++) {
            List<String> hList  = getAllMazePathsWithJumps(startRow, startCol+i,endRow,endCol, s+"h"+i);
//            List<String> vList = getAllMazePathsWithJumps(startRow+i, startCol,endRow,endCol, s+"v"+i);
//            List<String> dList = getAllMazePathsWithJumps(startRow+i, startCol+i,endRow,endCol, s+"d"+i);
            //paths.addAll(hList);
//            paths.addAll(vList);
//            paths.addAll(dList);
        }

        for(int i=1;i<=matrixSize-startRow;i++) {
//            List<String> hList  = getAllMazePathsWithJumps(startRow, startCol+i,endRow,endCol, s+"h"+i);
            List<String> vList = getAllMazePathsWithJumps(startRow+i, startCol,endRow,endCol, s+"v"+i);
//            List<String> dList = getAllMazePathsWithJumps(startRow+i, startCol+i,endRow,endCol, s+"d"+i);
//            paths.addAll(hList);
            //paths.addAll(vList);
            //paths.addAll(dList);
        }

        for(int i=1;i<=matrixSize-startRow && i<=matrixSize-startCol ;i++) {
//            List<String> hList  = getAllMazePathsWithJumps(startRow, startCol+i,endRow,endCol, s+"h"+i);
//            List<String> vList = getAllMazePathsWithJumps(startRow+i, startCol,endRow,endCol, s+"v"+i);
            List<String> dList = getAllMazePathsWithJumps(startRow+i, startCol+i,endRow,endCol, s+"d"+i);
//            paths.addAll(hList);
//            paths.addAll(vList);
            //paths.addAll(dList);
        }

        return paths;

    }
}
