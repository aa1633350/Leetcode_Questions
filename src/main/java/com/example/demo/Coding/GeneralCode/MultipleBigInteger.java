package com.example.demo.Coding.GeneralCode;

import java.net.HttpURLConnection;
// EPAM second round.
public class MultipleBigInteger {

    private static String multiply(String num1, String num2) {
        boolean isNegative = (num1.charAt(0) == '-' && num2.charAt(0) != '-')
                             || (num1.charAt(0) != '-' && num2.charAt(0) == '-');

        num1 = num1.replace("-", "");
        num2 = num2.replace("-", "");

        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        int [] result = new int [num1.length() + num2.length()];

        for(int i=0;i<num1.length();i++) {
            for(int j=0;j<num2.length();j++) {
                result[i+j] += (num1.charAt(i)-'0') * (num2.charAt(j)-'0'); // 9 * 5 => 45 % 10 = 5, 45/10 = 4
                result[i+j+1] += result[i+j] / 10;
                result[i+j] = result[i+j] % 10;
            }
        }
        // concat final result to StringBuilder.
        StringBuilder sb = new StringBuilder();
        for(int i=result.length-1;i>=0;i--) {
            sb.append(result[i]);
        }

        // need to handle leading zeros and delete them.
        while(sb.length() > 1  && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        if(isNegative && sb.charAt(0) != '0') {
            sb.insert(0, "-");
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        String num1 = "999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999";
        String num2 = "-0";
        String result = multiply(num1, num2);
        System.out.println("Multiplication result of big numbers : " + result);

    }

    // ACID Properties
    // A -> Atomicity
    // C -> Consistency : database correctness should be same before and after the transaction
    // I -> Isolation : Multiple transaction should occur independently without one effecting the other.
    // D -> Durability : The values once committed to database should persist even in case of network/transient failures.

    // Before transaction occurs : 500, 200 => 700
    // After transaction occurs : 400, 200 => 600

    // Circuit Breaker

    // Load balancing and Service Discovery : Distributes the network traffic
    // Service discovery : Enables service.


    // Design Patterns
    // Singleton Design Pattern
    // Builder Design Pattern:
    // Factory Design Pattern:
    // Decorator Design Pattern:

    // different bean scopes :

}
