package com.example.demo.Coding.GeneralCode;

import java.util.Arrays;

public class NextLexographicString {

    public static String swap (String str, int start, int end) {
        char temp = str.charAt(end);
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(end,sb.charAt(start));
        sb.setCharAt(start,temp);
        return sb.toString();
    }
    public static String biggerIsGreater(String w) {
        int index=-1;
        String firstPart="";
        String endPart = "";
        for ( int i = w.length()-1 ; i > 0 ; i--) {

            if (w.charAt(i)-'0' > w.charAt(i-1)-'0') {
                index = i-1;
                break;
            }
        }
        if( index == -1){
            return "no answer";
        }
        //System.out.println("Index is "+index);

        //System.out.println(firstPart);
        int swapIndex=-1;
        for (int i=index+1 ; i<w.length(); i++) {
            if(w.charAt(i) -'0' > w.charAt(index) - '0') {
                swapIndex = i;
            }
        }
        w = swap(w,index, swapIndex);
        firstPart = w.substring(0,index+1);
        //System.out.println(w);
        endPart = w.substring(index+1);
        //System.out.println(endPart);
        char [] tempArray = endPart.toCharArray();
        Arrays.sort(tempArray);
        endPart = new String(tempArray);
        //System.out.println(endPart);
        firstPart = firstPart.concat(endPart);
        return firstPart;

    }

    public static void main(String[] args) {
        System.out.println(biggerIsGreater("chatgpt"));
    }
}
