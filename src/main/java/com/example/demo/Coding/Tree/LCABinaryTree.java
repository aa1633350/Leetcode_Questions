package com.example.demo.Coding.Tree;

// Java implementation to print the path from root
// to a given node in a binary tree
import java.util.ArrayList;
public class LCABinaryTree {

    // Returns true if there is a path from root
    // to the given node. It also populates
    // 'arr' with the given path
    static void hasPath(Node p, ArrayList<Integer> path, int x)
    {
        if(p!=null){
            path.add(p.data);
            System.out.println(p.data);
            if(p.data == x) {
                return;
            }
            hasPath(p.left,path,x);
            hasPath(p.right,path,x);
            path.remove(path.size()-1);
        }
    }

    // function to print the path from root to the
    // given node if the node lies in the binary tree
    public static void printPath(Node root, int x)
    {
        // ArrayList to store the path
        ArrayList<Integer> arr=new ArrayList<>();
        hasPath(root,arr,x);

            for (int i=0; i<arr.size()-1; i++)
                System.out.print(arr.get(i)+"->");
            System.out.print(arr.get(arr.size() - 1));

    }

    public static void main(String args[]) {
        Node root=new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        int x=5;
        printPath(root, x);
    }
}

// A node of binary tree
class Node
{
    int data;
    Node left, right;
    Node(int data)
    {
        this.data=data;
        left=right=null;
    }
}