package com.example.demo.MachineCodingPractice.CustomComparators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Student {

    public static void main(String[] args) {
        List<StudentComparable> studentList = Arrays.asList(
                new StudentComparable(12,65,174),
                new StudentComparable(23,54, 187),
                new StudentComparable(13,84, 167),
                new StudentComparable(3,40, 180)
                );

        Collections.sort(studentList, new StudentComparable());
        for(StudentComparable student: studentList) {
            System.out.println(student);
        }
    }
}
