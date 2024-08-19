package com.example.demo.Coding.Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpecialStringAgain {
    private static final Pattern MSG_BUNDLE_REGEX = Pattern.compile("^\\[\\[\\$[a-zA-Z0-9]+\\.[a-zA-Z0-9_]+\\(\\)\\]\\]$");
    private static final Pattern PAYLOAD_EXP_PATTERN = Pattern.compile("\\{([a-zA-Z]+)\\((\\d+)\\)\\}");
    private static boolean isMiddleCharacterDifferent(String substring) {
        int left = 0;
        int right = substring.length() - 1;
        char middle = substring.charAt(left + (right - left) / 2);
        while (left < right) {
            if (substring.charAt(left) != substring.charAt(right) || (substring.charAt(left)== middle || substring.charAt(right)== middle)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static long substrCount(int n, String s) {
        long count=n, sameChar=0;
        int k=0;
        while(k<n) {

            int j=k+1;
            while(j<n && s.charAt(k)==s.charAt(j)) {
                j++;
                sameChar++;
            }
            count += (sameChar*(sameChar+1))/2;
            k=j;
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j < s.length(); j += 2) {
                if ((j-i)%2==0 && isMiddleCharacterDifferent(s.substring(i, j+1))) {
                    count++;
                }
            }
        }
        return count;


    }

    private static void jira4525() {
        String jsonString = "{stripeRunID(10)}";
//        String jsonString = "{"
//                + " \"id\": 123,"
//                + " \"name\": \"John Doe\","
//                + " \"email\": \"johndoe@example.com\","
//                + " \"address\": {"
//                + "    \"street\": \"123 Main St\","
//                + "    \"city\": \"Anytown\","
//                + "    \"state\": \"CA\","
//                + "    \"zip\": \"12345\""
//                + " },"
//                + " \"phone_numbers\": ["
//                + "    {"
//                + "       \"type\": \"home\","
//                + "       \"number\": \"555-1234\""
//                + "    },"
//                + "    {"
//                + "       \"type\": \"work\","
//                + "       \"number\": \"555-5678\""
//                + "    }"
//                + " ]"
//                + "}";
        Pattern jsonPattern = Pattern.compile("^\\s*\\{.*\\}\\s*$");
        Matcher matcher = jsonPattern.matcher(jsonString);

        if (matcher.matches()) {
            System.out.println("The string is a JSON object.");
        } else {
            System.out.println("The string is not a JSON object.");
        }

    }

    public static void main(String[] args) {

        jira4525();

//        String jsonStr = "{\"key\":\"value\"}";
//        //String x = "{randomNumber(10,20)}";
//        String paternC = ".*\\{\\s*(.*\\(.*\\))?\\s*}.*";
//        //Pattern PAYLOAD_EXP_PATTERN = Pattern.compile(".*\\{\\s*(.*\\(.*\\))?\\s*}.*");
//        Pattern PAYLOAD_EXP_PATTERN = Pattern.compile(paternC);
//        Matcher matcher = PAYLOAD_EXP_PATTERN.matcher(jsonStr);
//        //Matcher matcher = PAYLOAD_EXP_PATTERN.matcher(x);
//
//        if (matcher.matches()) {
//            String jsonString = matcher.group(1);
//            System.out.println(jsonString);
////            JSONObject jsonObj = new JSONObject(jsonString);
////            System.out.println(jsonObj);
//        } else{
//            System.out.println("mc");
//        }

//        System.out.println(substrCount(5, "asasd"));
//        String bundle = "[[$invbundle.TOTAL_AMOUNT_GREATER_THAN_3500()]]";
//        if(MSG_BUNDLE_REGEX.matcher(bundle).matches()) {
//            System.out.println("Hello");
//        }
//        String expression = "{stripeWithTestRunId(10)}";
//        Matcher matcher = PAYLOAD_EXP_PATTERN.matcher(expression);
//        if(!matcher.find()) {
//            return;
//        }
//        String method = matcher.group(1);
//        String param = matcher.group(2);
//
//        System.out.println(method);
//        System.out.println(param);
//        int matrix[][] = {{1,3},{2,4},{10,11},{10,12},{8,9}};
//        setZeros(matrix);
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.add(2);
//        arrayList.add(1);
//        arrayList.add(3);
//        arrayList.add(0);
//        List<Integer> ansList = nextPermutation(arrayList);
//        System.out.println(ansList);

    }




    public static void setZeros(int matrix[][]) {

        Arrays.sort(matrix);
        for(int [] mat : matrix) {
            for(int ele : mat) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }


    }

    public static ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation)
    {

        List<Integer> ans = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        List<Integer> begPartOfList = new ArrayList<>();
        int size = permutation.size();
        for(int i=size-1;i>=1;i--) {

            // if desceding order
            if(permutation.get(i) > permutation.get(i-1)) {
                int pivot = permutation.get(i-1);
                int minNumber = Integer.MAX_VALUE;
                int minNumIdx = 0;


                for(int j=i;j<size;j++) {
                    if(permutation.get(j)>pivot) {
                        minNumber = Math.min(permutation.get(j), minNumber);
                        minNumIdx = j;
                    }
                }

                permutation.remove(i-1);
                permutation.add(i-1,minNumber);
                permutation.remove(minNumIdx);
                permutation.add(minNumIdx,pivot);
                tempList = permutation.subList(i,size);
                begPartOfList = permutation.subList(0, i);
                Collections.sort(tempList);
                ans.addAll(begPartOfList);
                ans.addAll(tempList);
                break;

            }
        }


        return new ArrayList<>(ans);
    }
}
