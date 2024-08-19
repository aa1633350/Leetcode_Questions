package com.example.demo.Coding.GeneralCode;

import java.time.LocalTime;

public class TestRunIdInMillis {

    public static int generateTestRunId() {
        // Retrieve the current time
        LocalTime currentTime = LocalTime.now();
        System.out.println(currentTime.getNano());
        // Extract the millisecond part
        long millisecond = currentTime.toNanoOfDay() / 1000000;
        System.out.println("Seconds passed " + currentTime.toSecondOfDay());


        // Format the millisecond part with the desired length
//        String testRunId = String.format("%0" + length + "d", millisecond);

        return (int)millisecond;
    }

    public static void main(String[] args) {
        System.out.println("Miliseconds passed " + generateTestRunId());
    }

}
