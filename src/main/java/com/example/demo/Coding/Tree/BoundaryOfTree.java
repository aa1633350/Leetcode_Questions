package com.example.demo.Coding.Tree;

// Java program to print boundary traversal of binary tree

import java.util.ArrayList;
import java.util.List;

/* A binary tree node has data, pointer to left child
and a pointer to right child */
class TreeNode_Boundary {
    int val;
    TreeNode_Boundary left, right;

    TreeNode_Boundary(int item)
    {
        val = item;
        left = right = null;
    }
}

class BinaryTree {
    TreeNode_Boundary root;

    // A simple function to print leaf nodes of a binary tree
    void printLeaves(TreeNode_Boundary treeNodeBoundary, List<Integer> leavesNodesData)
    {
        if (treeNodeBoundary == null)
            return;

        printLeaves(treeNodeBoundary.left, leavesNodesData);
        // Print it if it is a leaf node
        if (treeNodeBoundary.left == null && treeNodeBoundary.right == null) {
            leavesNodesData.add(treeNodeBoundary.val);
        }

        printLeaves(treeNodeBoundary.right, leavesNodesData);
    }

    // A function to print all left boundary nodes, except a leaf node.
    // Print the nodes in TOP DOWN manner
    void printBoundaryLeft(TreeNode_Boundary treeRoot, List<Integer> leftNodesData)
    {
        if (treeRoot == null)
            return;

        if (treeRoot.left != null) {
            // to ensure top down order, print the node
            // before calling itself for left subtree
            leftNodesData.add(treeRoot.val);
            printBoundaryLeft(treeRoot.left, leftNodesData);
        }
        else if (treeRoot.right != null) {
            leftNodesData.add(this.root.val);
            printBoundaryLeft(treeRoot.right, leftNodesData);
        }

        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }

    // A function to print all right boundary nodes, except a leaf node
    // Print the nodes in BOTTOM UP manner
    void printBoundaryRight(TreeNode_Boundary treeRoot, List<Integer> rightNodesData)
    {
        if (treeRoot == null)
            return;

        if (treeRoot.right != null) {
            // to ensure bottom up order, first call for right
            // subtree, then print this node
            printBoundaryRight(treeRoot.right, rightNodesData);
            rightNodesData.add(treeRoot.val);
        }
        else if (treeRoot.left != null) {
            printBoundaryRight(treeRoot.left, rightNodesData);
            rightNodesData.add(treeRoot.val);
        }
        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }

    // A function to do boundary traversal of a given binary tree
    void printBoundary(TreeNode_Boundary treeNodeBoundary)
    {
        if (treeNodeBoundary == null)
            return;

        System.out.print(treeNodeBoundary.val + " ");

        // Print the left boundary in top-down manner.
        List<Integer> nodesData = new ArrayList<>();
        printBoundaryLeft(treeNodeBoundary.left, nodesData);

        // Print all leaf nodes
        printLeaves(treeNodeBoundary.left, nodesData);
        printLeaves(treeNodeBoundary.right, nodesData);

        // Print the right boundary in bottom-up manner
        printBoundaryRight(treeNodeBoundary.right, nodesData);
        for (int treeNodeVal : nodesData) {
            System.out.print(treeNodeVal + " ");
        }
    }

    // Driver program to test above functions
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode_Boundary(3);
        tree.root.left = new TreeNode_Boundary(5);
        tree.root.left.left = new TreeNode_Boundary(6);
        tree.root.left.right = new TreeNode_Boundary(2);
        tree.root.left.right.left = new TreeNode_Boundary(7);
        tree.root.left.right.right = new TreeNode_Boundary(4);
        tree.root.left.right.left.left = new TreeNode_Boundary(9);
        tree.root.left.right.left.right = new TreeNode_Boundary(-1);
        tree.root.left.right.left.right.left = new TreeNode_Boundary(10);
        tree.root.left.right.left.right.right = new TreeNode_Boundary(11);
        tree.root.right = new TreeNode_Boundary(12);
        tree.root.right.left = new TreeNode_Boundary(0);
        tree.root.right.right = new TreeNode_Boundary(8);
        tree.printBoundary(tree.root);
    }
}

