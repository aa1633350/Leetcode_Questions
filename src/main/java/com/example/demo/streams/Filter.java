package com.example.demo.streams;

import com.example.demo.InterfaceCheck.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Filter {
    private static boolean checkEven (int num) {
        return num%2==0;
    }
    public static void main(String[] args) {
        /*Predicate<Integer> checkEven = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return (integer % 2 == 0);
            }
        };
        List <Integer> nums = Arrays.asList(1,2,2,4);
        nums.stream().filter(checkEven).map(n -> n*2).forEach(System.out::println);*/

        List <String> names = Arrays.asList("Aditya","Saurabh", "Santosh", "Poonam", "sxjjjjjjj");
        List <String> result = names.stream().filter(x-> x.contains("s") && x.length() > 5 && x.startsWith("a"))
                .collect(Collectors.toList());
        List<Integer> lengths = names.stream().map(String::length).collect(Collectors.toList());
        System.out.println(names.stream().map(str -> str.replace("a","1"))
                .map(String::toUpperCase).collect(Collectors.toList()).stream().filter(x -> x.length() == 6).count());
        System.out.println(result);
        System.out.println(lengths);

        // Counting empty strings in a list.
        System.out.println("Empty String count in a list");
        List<String> testList = Arrays.asList("Aditya","","Oracle","   ", "","chair");
        long emptyStringCount = testList.stream().filter(s -> s.trim().isEmpty()).count();
        System.out.println(emptyStringCount);

        // Remove all empty strings in a list.
        System.out.println("List after removing all empty strings is : ");
        List<String> listWithoutEmptyString = testList.stream().filter(s -> !s.trim().isEmpty()).collect(Collectors.toList());
        System.out.println(listWithoutEmptyString);

        // Convert String to uppercase and Join them with coma
        System.out.println("String after joining all strings with comma is : ");
        List<String> countriesList = Arrays.asList("India","USA","Japan","China", "France","Russia");
        //String output = String.join(", ", countriesList);
        String output = countriesList.stream().map(s->s.toUpperCase()).collect(Collectors.joining(","));
        System.out.println(output);

        // Create a List of the square of all distinct numbers
        System.out.println("List of unique squared numbers : ");
        List<Integer> nums = Arrays.asList(3,2,1,4,4,6,23,1,1);
        List<Integer> squaredNums = nums.stream().distinct().map(x->x*2).collect(Collectors.toList());
        System.out.println(squaredNums);
    }
}
