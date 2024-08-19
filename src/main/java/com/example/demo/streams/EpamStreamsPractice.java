package com.example.demo.streams;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    String city;
    Gender gender;
    int age;

    public Employee(int id, String name, String city, Gender gender, int age) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public Gender getGender() {
        return gender;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }
}
public class EpamStreamsPractice {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "Noida", Gender.MALE, 20),
                new Employee(2, "Bob", "Delhi", Gender.MALE, 12),
                new Employee(3, "Charlie", "Noida", Gender.MALE, 25),
                new Employee(4, "Dave", "Mumbai", Gender.MALE, 67),
                new Employee(5, "Eve", "Noida", Gender.FEMALE, 20)
        );

        List<Employee> noida = employees.stream().filter(employee ->  employee.getCity().equals("Noida")).collect(Collectors.toList());
        List<Employee> empNames = noida.stream().sorted(Comparator.comparing(Employee::getName).reversed()).collect(Collectors.toList());
        for(Employee e : empNames) {
            System.out.println(e.name);
        }

        // Get list of all male employees
        List<Employee> maleEmployees = employees.stream().filter(employee ->
                employee.getGender().equals(Gender.MALE)).collect(Collectors.toList());
        // :: is called method reference operator.
        //maleEmployees.forEach(System.out::println);

        // Sort all male employees based on their age in ascending order.
        List<Employee> sortedMaleEmployees = employees.stream().filter(employee -> employee.getGender().equals(Gender.MALE))
                .sorted(Comparator.comparing(Employee::getAge)).collect(Collectors.toList());
        System.out.println("Male employees in ascending order");
        sortedMaleEmployees.forEach(System.out::println);

        // Sort all male employees based on their age in descending order.
        List<Employee> sortedMaleEmployeesDesc = employees.stream().filter(employee -> employee.getGender().equals(Gender.MALE))
                .sorted(Comparator.comparing(Employee::getAge).reversed()).collect(Collectors.toList());
        System.out.println("Male employees in descending order");
        sortedMaleEmployeesDesc.forEach(System.out::println);

        // String s = "asdfaghjklkjhgfdsa" Find the first repeating
        // character in the given string using streams and lambda expression. output - a
        String str = "asdfaghjklkjhgfdsa";
        Set<Character> set = new HashSet<>();
        Optional<Character> charT = str.chars().mapToObj(ch -> (char)ch).filter(ch -> !set.add(ch)).findFirst();
        if(charT.isPresent()) {
            System.out.println(charT.get());
        }
        System.out.println("<=Diff====>");
        // the then comparing part : "if two employees have same age then they will be sorted ascending based on their gender,
        // with female being higher priority then male
        List<Employee> someEmp = employees.stream().sorted(Comparator.comparing(Employee::getAge).reversed()
                .thenComparing(Employee::getGender)).collect(Collectors.toList());
        someEmp.forEach(System.out::println);

        // allMatch returns a boolean which says that a condition 'predicate'
        // should be valid for all the elements in stream.
        boolean allMatch = employees.stream().allMatch(employee -> employee.getAge() > 50);
        System.out.println("All Match "+ allMatch);

        boolean anyMatch = employees.stream().anyMatch(employee -> employee.getAge() > 50);
        System.out.println("Any Match "+ anyMatch);
        System.out.println("Max Age" );
        employees.stream().max(Comparator.comparing(Employee::getAge)).ifPresent(System.out::println);
        Optional<Employee> maxAge = employees.stream().max(Comparator.comparing(Employee::getAge));
        if(maxAge.isPresent()) {
            maxAge.toString();
        }
        //System.out.println();
    }

}
