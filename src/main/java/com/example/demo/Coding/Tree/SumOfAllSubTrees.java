package com.example.demo.Coding.Tree;

import java.util.List;

public class SumOfAllSubTrees {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
    Pass tree ka root and list to store all subtree sums.
     **/
    private long findTreeSum(TreeNode root, List<Long> allSubTreeSums) {
        if(root==null) {
            return 0;
        }

        long left = findTreeSum(root.left, allSubTreeSums);
        long right = findTreeSum(root.right, allSubTreeSums);
        long sum = left + right + root.val;
        allSubTreeSums.add(sum);
        return sum;

    }



}
