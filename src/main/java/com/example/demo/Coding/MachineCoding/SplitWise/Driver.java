package com.example.demo.Coding.MachineCoding.SplitWise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        // Create few users;

        User userOne = new User(1,"A","some@gmail.com", 1234,0);
        User userTwo = new User(2,"B","abc@gmail.com", 12345,0);
        User userThree = new User(3,"C","xyz@gmail.com", 12346,0);
        User userFour = new User(4,"D","pqr@gmail.com", 12347,0);

        List<User> userList = new ArrayList<>(Arrays.asList(userOne,userTwo,userThree,userFour));

        ShareExpense shareExpense = new ShareExpense(userList);
        UserService userService = new UserService(userList);
        while(true) {
            Scanner sc = new Scanner(System.in);
            String [] command = sc.nextLine().split(" ");
            Type type = Type.of(command[0]);
            switch (type) {
                case EXPENSE:
                    String userName = command[1];
                    double amount = Double.parseDouble(command[2]);
                    int noOfPerson = Integer.parseInt(command[3]);
                    List<User> owedUsers = new ArrayList<>();
                    for(int i=0; i<noOfPerson; i++) {
                        String user = sc.next();
                        owedUsers.add(userService.getUser(user));
                    }
                    int expenseIndex = noOfPerson + 4;
                    Expense expense = Expense.of(command[expenseIndex]);
                    switch (expense) {
                        case EQUAL:
                            shareExpense.shareExpenseEqually(userName,amount,owedUsers);
                        case EXACT:
                        case PERCENT:
                    }
                case SHOW:
                case QUIT:
            }
        }
    }
}
