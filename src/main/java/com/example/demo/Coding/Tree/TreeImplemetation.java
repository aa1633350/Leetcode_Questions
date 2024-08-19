package com.example.demo.Coding.Tree;



class Node2 {

    int data;
    Node2 left,right;
    Node2(int data) {
        this.data = data;
        left=right=null;
    }



    public static void main(String[] args) {
        Node2 root = new Node2(10);
        root.left = new Node2(3);
        root.right = new Node2(3);
    }

}
