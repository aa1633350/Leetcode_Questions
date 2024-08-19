package com.example.demo.IO;

import java.util.*;
import java.util.stream.Collectors;

class Parent {

     void fun1() {
        System.out.println("here");
    }
}
public class DemoMain extends Parent{


    public void fun1() {
        super.fun1();
        System.out.println("in child");
    }

    public static void main(String[] args) {

        DemoMain demoMain = new DemoMain();
        demoMain.fun1();

    }

}
//List<Integer> list1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());