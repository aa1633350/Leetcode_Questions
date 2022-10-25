package com.example.demo.Coding.GeneralCode;

public class CompressString {

    public static int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int count = 1, index=0;
        for(int i=1;i<chars.length;i++) {
            if(chars[i-1] == chars[i]) {
                count++;
            } else {
                // sb.append(chars[i-1]);
                // if(count!=1) {
                //     sb.append(count);
                // }
                chars[index++] = chars[i-1];
                if(count!=1) {
                    chars[index++] = (char) (count + '0');
                }

                count = 1;
            }
        }
        return chars.length;
    }

    public static void main(String[] args) {
        char [] chars = {'a','a','b','b','c','c','c'};
        System.out.println(compress(chars));
    }
}
