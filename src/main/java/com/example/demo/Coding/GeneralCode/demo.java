package com.example.demo.Coding.GeneralCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class demo {

    private static final Pattern RUN_ID_EXPR_REGEX = Pattern.compile("\\{\\$(\\w+)\\((\\d+)\\)\\}");
    private static void runIdMatcher() {
        String resPath = "/invoices/{$config.apiVersion}/invoices/{$addTestRunId(20)}";
        Matcher runIdExpressionMatcher = RUN_ID_EXPR_REGEX.matcher(resPath);
        if (runIdExpressionMatcher.find()) {
            String match = runIdExpressionMatcher.group(); // match = "{$addTestRunId(20)}"
            System.out.println(match);
            String staticValue = runIdExpressionMatcher.group(2); // staticValue = "20"
            System.out.println(staticValue);
            long testRunId = 120; // testRunId = 120
            String stripedValue = String.valueOf(testRunId + Long.parseLong(staticValue)); // stripedValue = "140"
            System.out.println("Striped run id value " + stripedValue); // Logging: "Striped run id value 140"
            resPath = resPath.replace(match, stripedValue); // resourcePath = "/invoices/{$config.apiVersion}/invoices/140"
        } else {
            System.out.println("No match");
        }

        System.out.println(resPath);
    }

    public static void main(String[] args) throws IOException {
        runIdMatcher();



    }


}
