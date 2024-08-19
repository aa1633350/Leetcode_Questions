package com.example.demo.Coding.GeneralCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ListNode2 {
    int data;
    ListNode2 next;
    ListNode2(int data) {
        this.data = data;
    }
}
public class StreamEpam {

    public static void main(String[] args) {
//        String s = "string data to count each character";
//        Map<Character,Long> freqMap = s.chars().mapToObj(c -> (char) c).filter(c-> c!=' ').collect(
//                Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        System.out.println(freqMap);

        ListNode2 head = new ListNode2(10);
        head.next = new ListNode2(20);
        head.next.next = new ListNode2(30);
        head.next.next.next = new ListNode2(40);
        head.next.next.next.next = new ListNode2(50);
        head.next.next.next.next.next = new ListNode2(60);

//        ListNode newHead = rotateLinkedList(head, 2);
////        System.out.println(newHead.data);
//        while(newHead != null) {
//            System.out.println(newHead.data + " ");
//            newHead = newHead.next;
//        }
        String [] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = findAnagrams(strs);
        for(List<String> r : result) {
            System.out.println(r);
        }

    }

    private static ListNode2 rotateLinkedList(ListNode2 head, int k) {
        if(k==0) {
            return head;
        }
        ListNode2 curr = head, prev= null, prevHead = head;
        ListNode2 newHead;
        while(curr.next != null && k > 0) {
            prev=curr;
            curr = curr.next;
            k--;
        }
        newHead = curr;
        prev.next = null;
        while(curr.next != null) {
            curr=curr.next;
        }
        curr.next = prevHead;
        return newHead;
    }
    // [eat, tea, tan, ate, nat, bat]
    private static List<List<String>> findAnagrams(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> anagramMap = new HashMap<>();
        for(String s : strings) {
            char [] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray); // aet -> eat
            anagramMap.computeIfAbsent(sortedStr, list-> new ArrayList<>()).add(s);
        }

        for(Map.Entry<String, List<String>> entry : anagramMap.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}
