package com.kn.tip.problem.interviewbit;

import java.util.ArrayList;
import java.util.Stack;

/**
 * https://www.interviewbit.com/problems/preorder-traversal/
 *
 * Preorder (Root, Left, Right)
 */
public class PreorderTreeTraversal {
  public ArrayList<Integer> preorderTraversal(final TreeNode a) {
    final ArrayList<Integer> result = new ArrayList<>();
    final Stack<TreeNode> stack = new Stack<>();
    stack.push(a);
    while (!stack.isEmpty()) {
      final TreeNode current = stack.pop();
      result.add(current.val);
      if (current.right != null) {
        stack.push(current.right);
      }
      if (current.left != null) {
        stack.push(current.left);
      }
    }

    return result;
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(final int x) {
      val = x;
    }
  }
}
