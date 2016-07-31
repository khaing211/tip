package com.kn.tip.problem.leetcode;

public class PathSum {
  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }

    if (root.left == null && root.right == null && root.val == sum) {
      return true;
    }

    final int partialSum = sum - root.val;

    if (root.left != null && hasPathSum(root.left, partialSum)) {
      return true;
    }

    if (root.right != null && hasPathSum(root.right, partialSum)) {
      return true;
    }

    return false;
  }
}
