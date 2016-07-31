package com.kn.tip.problem.ctci;

import com.kn.tip.datastructure.Pair;
import com.kn.tip.datastructure.TreeNode;

public class CheckBalancedTree {
  // how would you write this in iterative form?
  // to reduce space?
  public static <T> Pair<Boolean, Integer> check(TreeNode<T> root) {
    if (root == null) {
      return new Pair<>(true, 0);
    } else {
      Pair<Boolean, Integer> left = check(root.getLeft());
      Pair<Boolean, Integer> right = check(root.getRight());

      boolean balance = left.getFirst() && right.getFirst()
          && Math.abs(left.getSecond() - right.getSecond()) <= 1;

      int height = 1 + Math.max(left.getSecond(), right.getSecond());

      return new Pair<>(balance, height);
    }
  }

  public static void main(String[] args) {
    TreeNode<Integer> root = MinimalTree.createBST(new int[] {1, 2});
    System.out.println(check(root).getFirst());
  }
}
