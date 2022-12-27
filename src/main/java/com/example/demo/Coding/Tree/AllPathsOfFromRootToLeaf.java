package com.example.demo.Coding.Tree;

import java.util.ArrayList;
import java.util.List;

public class AllPathsOfFromRootToLeaf {

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

    private void paths(TreeNode root, List<List<Integer>> allPaths, List<Integer> tempList) {
        if(root==null) {
            return;
        }


        if(root.left==null && root.right==null) {
            tempList.add(root.val);
            allPaths.add(new ArrayList<>(tempList));
            return;
        }
        tempList.add(root.val);
        if(root.left!=null) {
            paths(root.left,allPaths,tempList);
            tempList.remove(tempList.size()-1);
        }
        if(root.right!=null) {
            paths(root.right,allPaths,tempList);
            tempList.remove(tempList.size()-1);
        }
    }
}
