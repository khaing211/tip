package com.kn.tip.problem.interviewbit;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree, return the inorder traversal of its nodes’ values.
 *
 * Recursion is not allow.
 *
 * Work out on the paper help alot
 *
 * Hint: in order traversal is (left, root, right)
 */
public class InorderTreeTraversal {
  public ArrayList<Integer> inorderTraversal(final TreeNode a) {
    final ArrayList<Integer> element = new ArrayList<>();
    final Stack<TreeNode> stack = new Stack<>();
    pushLeft(stack, a);
    while (!stack.isEmpty()) {
      final TreeNode current = stack.pop();
      element.add(current.val);
      if (current.right != null) {
        pushLeft(stack, current.right);
      }
    }
    return element;
  }

  // Go left first
  private static void pushLeft(final Stack<TreeNode> stack, TreeNode current) {
    while (current != null) {
      stack.push(current);
      current = current.left;
    }
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
