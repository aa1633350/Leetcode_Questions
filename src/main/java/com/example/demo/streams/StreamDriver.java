package com.example.demo.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamDriver {


    public static void main(String[] args) {
        List<String> namesList = List.of("Aditya", "I", "How", "are", "ypu");
        System.out.println(namesList.stream().filter((String name) -> name.length() <=3).collect(Collectors.toList()));
        System.out.println(namesList.stream().map((String name) -> name.concat("xx")).collect(Collectors.toList()));

        int [] arr = {1,2,3,4,1,2,3};
        arr = Arrays.stream(arr).distinct().toArray();

        String [] numArr = {"10", "2", "3", "4"};
        int [] convertedArr = Arrays.stream(numArr).mapToInt((String num) -> Integer.parseInt(num)).toArray();
        for(int n : convertedArr) {
            System.out.println(n);
        }
        Set<Integer> duplicateSet = new HashSet<>();
        List<Integer> list = Arrays.asList(2,3,4,1,2,3);
        List<Integer> distinct = list.stream().distinct().toList();
        List<Integer> dupList = list.stream().filter(i -> !duplicateSet.add(i)).collect(Collectors.toList());
        System.out.println(dupList);

        List<List<String>> names = Arrays.asList(
                Arrays.asList("A", "B"),
                Arrays.asList("C", "D")
        );

        List<String> flattendNames = names.stream().flatMap(name -> name.stream()).collect(Collectors.toList());
        System.out.println(flattendNames);



    }
}