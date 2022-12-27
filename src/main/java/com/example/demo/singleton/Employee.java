package com.example.demo.singleton;

import java.util.Objects;

public class Employee {

    private int id;
    private String name;
    private boolean male;

    public Employee(int id, String name, boolean male) {
        this.id = id;
        this.name = name;
        this.male = male;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", male=" + male +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Employee employee = (Employee) o;
//        return id == employee.id ;
//        //&& male == employee.male && Objects.equals(name, employee.name)
//    }

    @Override
    public int hashCode() {
        return this.id ;
    }

    public static Employee createEmployee(String str) {
        String [] arr = str.split(",");
        return new Employee(Integer.parseInt(arr[0]),arr[1], Boolean.parseBoolean(arr[2]));
    }
}
