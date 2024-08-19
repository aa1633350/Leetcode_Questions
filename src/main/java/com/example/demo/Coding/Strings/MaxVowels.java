package com.example.demo.Coding.Strings;

public class MaxVowels {

    private boolean isVowel(char ch) {
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }
        return false;
    }
    public int maxVowels(String s, int k) {
        int vowelCount = 0, ans=0;
        int front=0,rear=k-1;
        for(int i=0;i<k;i++) {
            if(isVowel(s.charAt(i))) {
                vowelCount++;
            }
        }
        int n = s.length();
        while(rear < n) {

            if(isVowel(s.charAt(front)) && vowelCount > 0) {
                vowelCount--;
            }
            if(rear<n && isVowel(s.charAt(rear)) && vowelCount <=k) {
                vowelCount++;
            }

            front++;
            rear++;

            ans = Math.max(ans,vowelCount);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxVowels obj = new MaxVowels();
        String s = "abciiidef";
        System.out.println(obj.maxVowels(s,3));
    }
}
