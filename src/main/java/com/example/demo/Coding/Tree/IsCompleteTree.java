package com.example.demo.Coding.Tree;


import java.util.LinkedList;
import java.util.Queue;

//Definition for a binary tree node.
class TreeNode {
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
class Solution {
    public boolean isCompleteTree(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean nullNodePresent = false;
        while(!q.isEmpty()) {
            int size = q.size();

            while(size-- > 0) {
                TreeNode curr = q.poll();

                if(curr.left != null) {
                    q.add(curr.left);
                    if(nullNodePresent) {
                        return false;
                    }
                } else {
                    nullNodePresent = true;
                }

                if(curr.right != null) {
                    q.add(curr.right);
                    if(nullNodePresent) {
                        return false;
                    }
                } else {
                    nullNodePresent = true;
                }
            }


        }

        return true;

    }
}