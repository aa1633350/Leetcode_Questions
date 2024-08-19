package com.example.demo.Coding.Tree;

public class FindKthSmallestInBST {

    private int kthSmallest(TreeNode_Boundary root, int k, int[] count) {
        if (root == null) {
            return -1;
        }

        int left = kthSmallest(root.left, k, count);
        if (left != -1) {
            return left;
        }

        count[0]++;
        System.out.println("Node: " + root.val + ", Count: " + count[0]);
        if (count[0] == k) {
            return root.val;
        }

        return kthSmallest(root.right, k, count);
    }

    public int kthSmallest(TreeNode_Boundary root, int k) {
        int[] count = new int[1];
        return kthSmallest(root, k, count);
    }

    private TreeNode_Boundary insert(TreeNode_Boundary root, int val) {
        if (val == 0) {
            return root;
        }
        if (root == null) {
            return new TreeNode_Boundary(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void main(String[] args) {
        int[] nodes = {5, 3, 6, 2, 4, 0, 0, 1}; // Adjusted array with 0 instead of null
        int k = 3;
        FindKthSmallestInBST solution = new FindKthSmallestInBST();
        TreeNode_Boundary root = null;

        for (int node : nodes) {
            root = solution.insert(root, node);
        }

        int kthSmallest = solution.kthSmallest(root, k);
        System.out.println("The " + k + "th smallest element in the tree is: " + kthSmallest);
    }
}
