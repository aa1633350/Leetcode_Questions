package com.example.demo.MachineCodingPractice.CustomComparators;

import java.util.Comparator;

//Comparable<StudentComparable>
public class StudentComparable implements Comparator<StudentComparable> {

    int age;
    int wt;
    int ht;

    public StudentComparable() {

    }
    public StudentComparable(int age, int wt, int ht) {
        this.age = age;
        this.wt = wt;
        this.ht = ht;
    }

    // This will give natural ordering. i.e the smallest age will appear first.
//    @Override
//    public int compareTo(StudentComparable o) {
//        return Integer.compare(this.age, o.age);
//    }

    @Override
    public String toString() {
        return "StudentComparable{" +
                "age=" + age +
                ", wt=" + wt +
                ", ht=" + ht +
                '}';
    }

    @Override
    public int compare(StudentComparable o1, StudentComparable o2) {
        return o1.wt - o2.wt;
    }
}
