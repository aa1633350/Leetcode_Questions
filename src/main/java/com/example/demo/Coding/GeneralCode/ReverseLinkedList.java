package com.example.demo.Coding.GeneralCode;

//class ListNode2 {
//    int val;
//    ListNode2 next;
//    ListNode2(int x) {
//        val = x;
//        next = null;
//    }
//}
//
//
//public class ReverseLinkedList {
//
//    public ListNode2 reverseList(ListNode2 head) {
//        ListNode2 prev = null;
//        ListNode2 curr = head, temp=head;
//
//        while (curr != null) {
//            curr=curr.next;
//            temp.next=prev;
//            prev=temp;
//            temp=curr;
////            ListNode nextTemp = curr.next; // Store the next node
////            curr.next = prev;              // Reverse the current node's pointer
////            prev = curr;                   // Move prev to current node
////            curr = nextTemp;               // Move curr to the next node
//        }
//
//        return prev; // New head of the reversed list
//    }
//
//    public static void main(String[] args) {
//        // Create example linked list: 1 -> 2 -> 3 -> 4 -> 5
//        ListNode2 head = new ListNode2(1);
//        head.next = new ListNode2(2);
//        head.next.next = new ListNode2(3);
//        head.next.next.next = new ListNode2(4);
//        head.next.next.next.next = new ListNode2(5);
//
//        ReverseLinkedList solution = new ReverseLinkedList();
//        ListNode2 reversedHead = solution.reverseList(head);
//
//        // Print the reversed linked list
//        ListNode2 current = reversedHead;
//        while (current != null) {
//            System.out.print(current.val + " ");
//            current = current.next;
//        }
//        // Output should be: 5 4 3 2 1
//    }
//}
