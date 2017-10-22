package com.kn.tip.problem.interviewbit;

import java.util.Stack;

/**
 * https://www.interviewbit.com/problems/invert-the-binary-tree/
 *
 * Invert i.e. left-right becomes right-left
 */
public class InvertBinaryTree {
  public TreeNode invertTree(final TreeNode root) {
    final Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      final TreeNode node = stack.pop();
      final TreeNode tmp = node.right;
      node.right = node.left;
      node.left = tmp;
      if (node.left != null) {
        stack.push(node.left);
      }
      if (node.right != null) {
        stack.push(node.right);
      }
    }

    return root;
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
