package com.example.demo.Coding.GeneralCode;

import java.util.*;

public class GeneMutation {

    public int minMutation(String start, String end, String[] bank) {

        Set<String> stringBank = new HashSet<>(Arrays.asList(bank));
        String [] gene = {"A","C","G","T"};
        int len = start.length(), mutation = 0;
        List<Integer> diff = new ArrayList<>();
        for(int i=0;i<len;i++) {
            if(start.charAt(i) != end.charAt(i)) {
                diff.add(i);
            }
        }
        Queue<String> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                String str = q.poll();
                for(int i=0;i<diff.size();i++) {
                    String currStr = str;
                    int d = diff.get(i);
                    for(int j=0;j<4;j++) {
                        currStr = currStr.substring(0,d) + gene[j] + currStr.substring(d+1);
                        if(stringBank.contains(currStr)) {
                            mutation++;
                            q.add(currStr);
                        }
                        if(currStr.equals(end)) {
                            return mutation;
                        }
                    }

                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        GeneMutation geneMutation = new GeneMutation();
        String start = "AACCGGTT", end = "AAACGGTA";
        String [] bank = {"AACCGGTA","AACCGCTA","AAACGGTA"};
        System.out.println(geneMutation.minMutation(start, end, bank));
    }
}
