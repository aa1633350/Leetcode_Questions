package com.example.demo.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntegerStream {

    public static void main(String[] args) {

//        IntStream.
//                range(1,10).    // 10 is not inclusive in range
//                forEach(System.out :: print);
//        System.out.println("<=====================>");
//
//        IntStream.range(1,10).
//                skip(5).     // This skips the first five numbers
//                forEach(x -> System.out.println(x));
//
//        System.out.println("<=====================>");
//        int x = 1,y=5;
//        System.out.println(
//                IntStream.range(x,y).sum()
//        );
//        System.out.println("<=====================>");

//        Stream.of("Aditya","Oracle","Switch").sorted().findFirst().ifPresent(System.out :: println);
//
        String [] names = {"Al", "Saurabh", "swunx", "sum", "Aditya", "soon"};
        // maps the array to lower case and then filters on it to start with "s"
        // which is then sorted in reverse order you can also use -------> {(a,b) -> b.compareTo(a)}
//        Arrays.stream(names).map(s -> s.toLowerCase()).filter(x -> x.startsWith("s")).
//                sorted(Comparator.reverseOrder()).forEach(System.out :: println);
//        List<String> namesStartingWith_S = Arrays.stream(names).map(s -> s.toLowerCase()).filter(x -> x.startsWith("s")).
//                sorted(Comparator.reverseOrder()).collect(Collectors.toList());
//        namesStartingWith_S.forEach(System.out :: println);
//        Arrays.stream(names).
//                filter( x -> x.startsWith("s") || x.startsWith("S")).
//                sorted().forEach(System.out :: println);

        int [] nums = {2,4,6,8,10};
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
//        Arrays.stream(nums).map(x -> x*x).average().ifPresent(System.out :: println);
//        Arrays.stream(nums).map(x -> x*x).filter( y -> y%6 == 0).forEach(System.out :: println);

        // Double stream
//        double total = Stream.of(7.3,8.9,2.4).reduce(0.0, (Double a , Double b) -> a+b);
//        System.out.println("Total " + total);

        IntSummaryStatistics intSummaryStatistics = IntStream.of(nums).summaryStatistics();
        // you can use the intSummaryStatistics object to get count of elements, sum , minVal, maxVal, average etc.
        System.out.println(intSummaryStatistics);
    }
}
