package com.example.demo.singleton;

import java.util.HashSet;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Employee> set = new HashSet<>();
        Employee e1 = new Employee(0,"Aditya", true);
        Employee e2 = new Employee(0,"Aditya", true);
        Employee e3 = new Employee(1,"sdfghj", true);
        System.out.println(e1.equals(e2));
        //Employee employee = Employee.createEmployee();
//        if(!set.contains(e1)) {
//            set.add(e1);
//        }
//        if(!set.contains(e2)) {
//            set.add(e2);
//        }
//        if(!set.contains(e3)) {
//            set.add(e3);
//        }
        //set.add(e3);
//        while(sc.hasNext()) {
//            String Input = sc.next();
//            if(Input.equals("Q")) {
//                break;
//            }
//            Employee employee = Employee.createEmployee(Input);

//            set.add(employee);
//        }

        for(Employee e : set) {
            System.out.println(e.toString());
        }

    }
}
