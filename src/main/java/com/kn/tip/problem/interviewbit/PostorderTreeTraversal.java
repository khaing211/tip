package com.kn.tip.problem.interviewbit;

import java.util.ArrayList;
import java.util.Stack;

/**
 * https://www.interviewbit.com/problems/postorder-traversal/
 *
 * Postorder (Left, Right, Root)
 */
public class PostorderTreeTraversal {
  public ArrayList<Integer> postorderTraversal(final TreeNode a) {
    final ArrayList<Integer> result = new ArrayList<>();
    // when a process a node on this stack,
    // you can assume that all left children nodes is processed prior
    final Stack<TreeNode> leftNodesStack = new Stack<>();
    // when a process a node on this stack,
    // you can assume that all right children nodes is processed prior
    final Stack<TreeNode> rootNodesStack = new Stack<>();
    pushLeft(leftNodesStack, a);
    while (!leftNodesStack.isEmpty()) {
      final TreeNode current = leftNodesStack.peek();
      // If there is a right node
      if (current.right != null) {
        // if the right children have not processed
        if (rootNodesStack.isEmpty() || rootNodesStack.peek() != current) {
          pushLeft(leftNodesStack, current.right);
          // deferred process by pushing to rootNodesStack
          rootNodesStack.push(current);
        } else if (rootNodesStack.peek() == current) {
          // process the node since the right children nodes are processed
          rootNodesStack.pop();
          leftNodesStack.pop();
          result.add(current.val);
        }
      } else {
        result.add(current.val);
        leftNodesStack.pop();
      }
    }
    return result;
  }

  // Go left first
  private static void pushLeft(final Stack<TreeNode> deque, TreeNode current) {
    while (current != null) {
      deque.push(current);
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
