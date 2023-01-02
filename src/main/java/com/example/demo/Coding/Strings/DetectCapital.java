package com.example.demo.Coding.Strings;

public class DetectCapital {

    private boolean checkLower(String word) {
        int len = word.length();
        for(int i=0;i<len;i++) {
            if(Character.isUpperCase(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    private boolean checkUpper(String word) {
        int len = word.length();
        if(len>1 && Character.isUpperCase(word.charAt(1))) {
            for(int i=2;i<len;i++) {
                if(Character.isLowerCase(word.charAt(i))) {
                    return false;
                }
            }
        } else {
            for(int i=1;i<len;i++) {
                if(Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
        }

        return true;
    }
    public boolean detectCapitalUse(String word) {

        char firstChar = word.charAt(0);

        if(firstChar >= 'a' && firstChar <='z') {
            return checkLower(word);
        } else {
            return checkUpper(word);
        }
    }
}
